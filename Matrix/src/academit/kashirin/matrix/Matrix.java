package academit.kashirin.matrix;

import academit.kashirin.vector.Vector;

import java.util.StringJoiner;

public class Matrix {
    private Vector[] components;

    public Matrix(int n, int m) {
        this.components = new Vector[m];
        for (int i = 0; i < m; i++) {
            this.components[i] = new Vector(n);
        }
    }

    public Matrix(Matrix matrix) {
        this.components = new Vector[matrix.getSizeM()];
        for (int i = 0; i < matrix.getSizeM(); i++) {
            this.components[i] = new Vector(matrix.components[i]);
        }
    }

    public Matrix(double[][] component) {
        this.components = new Vector[component.length];
        int maxLength = component.length;
        for (double[] aComponent : component) {
            if (aComponent.length > maxLength) {
                maxLength = aComponent.length;
            }
        }
        for (int i = 0; i < component.length; i++) {
            this.components[i] = new Vector(maxLength, component[i]);

        }
    }

    public Matrix(Vector[] components) {
        this.components = new Vector[components.length];
        int maxLength = components.length;
        for (Vector component : components) {
            if (component.getSize() > maxLength) {
                maxLength = component.getSize();
            }
        }
        for (int i = 0; i < components.length; i++) {
            double[] save = new double[components[i].getSize()];
            for (int j = 0; j < components[i].getSize(); j++) {
                save[j] = components[i].getComponent(j);
            }
            this.components[i] = new Vector(maxLength, save);
        }
    }

    public int getSizeN() {
        return this.components[0].getSize();
    }

    public int getSizeM() {
        return this.components.length;
    }

    public Vector getLineVectorByIndex(int index) {
        if (index > getSizeM()) {
            throw new IllegalArgumentException("Индекса не существует");
        }
        return this.components[index];
    }

    public void setLineVectorByIndex(int index, Vector vector) {
        if (index > getSizeM()) {
            throw new IllegalArgumentException("Индекса не существует");
        }
        this.components[index] = new Vector(vector);
    }

    public Vector getColumnVectorByIndex(int index) {
        if (index > getSizeN()) {
            throw new IllegalArgumentException("Индекса не существует");
        }
        Vector columnByIndex = new Vector(components.length);
        for (int i = 0; i < components.length; i++) {
            columnByIndex.setComponent(i, components[i].getComponent(index));
        }
        return columnByIndex;
    }

    public void transposition() {
        Matrix matrix = new Matrix(this.components);
        this.components = new Vector[getSizeN()];
        for (int i = 0; i < matrix.getSizeN(); i++) {
            this.components[i] = matrix.getColumnVectorByIndex(i);
        }
    }

    public void multiplication(double scalar) {
        for (int i = 0; i < getSizeM(); i++) {
            this.components[i].multiplication(scalar);
        }
    }

    public double getDeterminant() {
        if ((getSizeN() != getSizeM()) && (getSizeN() > 4)) {
            throw new IllegalArgumentException("Размерность матриц не соответсвует условию");
        }
        double determinant = 0;
        if (getSizeN() == 2) {
            determinant = components[0].getComponent(0) * components[1].getComponent(1) - components[0].getComponent(1) * components[1].getComponent(0);
        }
        if (getSizeN() == 3) {
            determinant = components[0].getComponent(0) * components[1].getComponent(1) * components[2].getComponent(2) +
                    components[1].getComponent(0) * components[2].getComponent(1) * components[0].getComponent(2) +
                    components[0].getComponent(1) * components[1].getComponent(2) * components[2].getComponent(0) -
                    components[0].getComponent(2) * components[1].getComponent(1) * components[2].getComponent(0) -
                    components[1].getComponent(0) * components[0].getComponent(1) * components[2].getComponent(2) -
                    components[0].getComponent(0) * components[1].getComponent(2) * components[2].getComponent(1);
        }
        return determinant;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (Vector element : components) {
            joiner.add(element.toString());
        }
        return joiner.toString();
    }

    public Vector multiplicationByVector(Vector vector) {
        if (getSizeN() != vector.getSize()) {
            throw new IllegalArgumentException("Размерность матриц не соответсвует условию");
        }
        Vector result = new Vector(getSizeM());
        for (int i = 0; i < getSizeM(); i++) {
            double sum = 0;
            for (int j = 0; j < getSizeN(); j++) {
                sum += this.components[i].getComponent(j) * vector.getComponent(j);
            }
            result.setComponent(i, sum);
        }
        return result;
    }

    public void sum(Matrix matrix) {
        if ((getSizeN() != matrix.getSizeN()) && (getSizeM() != matrix.getSizeM())) {
            throw new IllegalArgumentException("Размерность матриц не соответсвует условию");
        }
        for (int i = 0; i < getSizeM(); i++) {
            for (int j = 0; j < getSizeN(); j++) {
                components[i].setComponent(j, components[i].getComponent(j) + matrix.components[i].getComponent(j));
            }
        }
    }

    public void difference(Matrix matrix) {
        if ((getSizeN() != matrix.getSizeN()) && (getSizeM() != matrix.getSizeM())) {
            throw new IllegalArgumentException("Размерность матриц не соответсвует условию");
        }
        for (int i = 0; i < getSizeM(); i++) {
            for (int j = 0; j < getSizeN(); j++) {
                components[i].setComponent(j, components[i].getComponent(j) - matrix.components[i].getComponent(j));
            }
        }
    }

    public static Matrix sum(Matrix matrix1, Matrix matrix2) {
        Matrix saveMatrix = new Matrix(matrix1);
        saveMatrix.sum(matrix2);
        return saveMatrix;
    }

    public static Matrix difference(Matrix matrix1, Matrix matrix2) {
        Matrix saveMatrix = new Matrix(matrix1);
        saveMatrix.difference(matrix2);
        return saveMatrix;
    }

    public static Matrix multiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getSizeN() != matrix2.getSizeM()) {
            throw new IllegalArgumentException("Размерность матриц не соответсвует условию");
        }
        Matrix saveMatrix = new Matrix(matrix2.getSizeN(), matrix1.getSizeM());
        for (int i = 0; i < matrix1.getSizeM(); i++) {
            for (int j = 0; j < matrix2.getSizeN(); j++) {
                double sum = 0;
                for (int m = 0; m < matrix1.getSizeN(); m++) {
                    sum += matrix1.components[i].getComponent(m) * matrix2.components[m].getComponent(j);
                }
                saveMatrix.components[i].setComponent(j, sum);
            }
        }
        return saveMatrix;
    }

}

