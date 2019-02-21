package academit.kashirin.matrix;

import academit.kashirin.vector.Vector;

import java.util.StringJoiner;

public class Matrix {
    private Vector[] vectors;

    public Matrix(int n, int m) {
        if (n == 0 || m == 0) {
            throw new IllegalArgumentException("Размер матрицы должен быть отличен от 0");
        }
        this.vectors = new Vector[m];

        for (int i = 0; i < m; i++) {
            this.vectors[i] = new Vector(n);
        }
    }

    public Matrix(Matrix matrix) {
        this.vectors = new Vector[matrix.getNumberRows()];

        for (int i = 0; i < matrix.getNumberRows(); i++) {
            this.vectors[i] = new Vector(matrix.vectors[i]);
        }
    }

    public Matrix(double[][] vector) {
        if (vector.length == 0) {
            throw new IllegalArgumentException("Размер матрицы должен быть отличен от 0");
        }
        this.vectors = new Vector[vector.length];
        int maxLength = vector.length;

        for (double[] component : vector) {
            if (component.length > maxLength) {
                maxLength = component.length;
            }
        }

        for (int i = 0; i < vector.length; i++) {
            this.vectors[i] = new Vector(maxLength, vector[i]);
        }
    }

    public Matrix(Vector[] vector) {
        if (vector.length == 0) {
            throw new IllegalArgumentException("Размер матрицы должен быть отличен от 0");
        }
        this.vectors = new Vector[vector.length];
        int maxLength = vector.length;

        for (Vector component : vector) {
            if (component.getSize() > maxLength) {
                maxLength = component.getSize();
            }
        }

        for (int i = 0; i < vector.length; i++) {
            double[] save = new double[vector[i].getSize()];
            for (int j = 0; j < vector[i].getSize(); j++) {
                save[j] = vector[i].getComponent(j);
            }
            this.vectors[i] = new Vector(maxLength, save);
        }
    }

    public int getNumberColumns() {
        return this.vectors[0].getSize();
    }

    public int getNumberRows() {
        return this.vectors.length;
    }

    public Vector getRow(int index) {
        if ((index >= getNumberRows()) || (index < 0)) {
            throw new IndexOutOfBoundsException("Индекса не существует");
        }
        Vector saveVector = new Vector(getNumberColumns());
        for (int i = 0; i < getNumberColumns(); i++) {
            saveVector.setComponent(i, this.vectors[index].getComponent(i));
        }
        return saveVector;
    }

    public void setRow(int index, Vector vector) {
        if (((index >= getNumberRows()) || index < 0) || (vector.getSize() > getNumberColumns())) {
            throw new IndexOutOfBoundsException("Индекса не существует");
        }
        this.vectors[index] = new Vector(vector);
    }

    public Vector getColumn(int index) {
        if ((index >= getNumberColumns()) || (index < 0)) {
            throw new IndexOutOfBoundsException("Индекса не существует");
        }
        Vector columnByIndex = new Vector(vectors.length);
        for (int i = 0; i < vectors.length; i++) {
            columnByIndex.setComponent(i, vectors[i].getComponent(index));
        }
        return columnByIndex;
    }

    public void transposition() {
        if (getNumberColumns() != getNumberRows()) {
            throw new IllegalArgumentException("Матрица не квадратная");
        }
        for (int i = 0; i < getNumberRows(); i++) {
            for (int j = i; j < getNumberColumns(); j++) {
                double temp = this.vectors[i].getComponent(j);
                this.vectors[i].setComponent(j, this.vectors[j].getComponent(i));
                this.vectors[j].setComponent(i, temp);
            }
        }
    }

    public void multiplication(double scalar) {
        for (int i = 0; i < getNumberRows(); i++) {
            this.vectors[i].multiplication(scalar);
        }
    }

    public double getDeterminant() {
        if (getNumberColumns() != getNumberRows()) {
            throw new IllegalArgumentException("Матрица не квадратная");
        }
        double determinant = 0.0;
        if (getNumberColumns() == 2) {
            determinant = this.vectors[0].getComponent(0) * this.vectors[1].getComponent(1) - this.vectors[1].getComponent(0) * this.vectors[0].getComponent(1);
        } else {
            int coefficient;
            for (int i = 0; i < getNumberColumns(); i++) {
                if (i % 2 == 1) {
                    coefficient = -1;
                } else {
                    coefficient = 1;
                }
                determinant += coefficient * this.vectors[0].getComponent(i) * GetMinor(this, 0, i).getDeterminant();
            }
        }
        return determinant;
    }

    private Matrix GetMinor(Matrix matrix, int row, int column) {
        int minorLength = matrix.getNumberRows() - 1;
        Matrix minor = new Matrix(minorLength, minorLength);
        int dI = 0;
        for (int i = 0; i <= minorLength; i++) {
            int dJ = 0;
            for (int j = 0; j <= minorLength; j++) {
                if (i == row) {
                    dI = 1;
                } else {
                    if (j == column) {
                        dJ = 1;
                    } else {
                        minor.vectors[i - dI].setComponent((j - dJ), matrix.vectors[i].getComponent(j));
                    }
                }
            }
        }
        return minor;
    }


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (Vector element : vectors) {
            joiner.add(element.toString());
        }
        return joiner.toString();
    }

    public Vector multiplicationByVector(Vector vector) {
        if (getNumberColumns() != vector.getSize()) {
            throw new IllegalArgumentException("Размерность матриц не соответсвует условию");
        }
        Vector result = new Vector(getNumberRows());
        for (int i = 0; i < getNumberRows(); i++) {
            double sum = 0;
            for (int j = 0; j < getNumberColumns(); j++) {
                sum += this.vectors[i].getComponent(j) * vector.getComponent(j);
            }
            result.setComponent(i, sum);
        }
        return result;
    }

    public void sum(Matrix matrix) {
        if ((getNumberColumns() != matrix.getNumberColumns()) && (getNumberRows() != matrix.getNumberRows())) {
            throw new IllegalArgumentException("Размерность матриц не соответсвует условию");
        }
        for (int i = 0; i < getNumberRows(); i++) {
            for (int j = 0; j < getNumberColumns(); j++) {
                vectors[i].setComponent(j, vectors[i].getComponent(j) + matrix.vectors[i].getComponent(j));
            }
        }
    }

    public void difference(Matrix matrix) {
        if ((getNumberColumns() != matrix.getNumberColumns()) && (getNumberRows() != matrix.getNumberRows())) {
            throw new IllegalArgumentException("Размерность матриц не соответсвует условию");
        }
        for (int i = 0; i < getNumberRows(); i++) {
            for (int j = 0; j < getNumberColumns(); j++) {
                vectors[i].setComponent(j, vectors[i].getComponent(j) - matrix.vectors[i].getComponent(j));
            }
        }
    }

    public static Matrix sum(Matrix matrix1, Matrix matrix2) {
        if ((matrix1.getNumberColumns() != matrix2.getNumberColumns()) && (matrix1.getNumberRows() != matrix2.getNumberRows())) {
            throw new IllegalArgumentException("Размерность матриц не соответсвует условию");
        }
        Matrix saveMatrix = new Matrix(matrix1);
        saveMatrix.sum(matrix2);
        return saveMatrix;
    }

    public static Matrix difference(Matrix matrix1, Matrix matrix2) {
        if ((matrix1.getNumberColumns() != matrix2.getNumberColumns()) && (matrix1.getNumberRows() != matrix2.getNumberRows())) {
            throw new IllegalArgumentException("Размерность матриц не соответсвует условию");
        }
        Matrix saveMatrix = new Matrix(matrix1);
        saveMatrix.difference(matrix2);
        return saveMatrix;
    }

    public static Matrix multiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getNumberColumns() != matrix2.getNumberRows()) {
            throw new IllegalArgumentException("Размерность матриц не соответсвует условию");
        }
        Matrix saveMatrix = new Matrix(matrix2.getNumberColumns(), matrix1.getNumberRows());
        for (int i = 0; i < matrix1.getNumberRows(); i++) {
            for (int j = 0; j < matrix2.getNumberColumns(); j++) {
                double sum = 0;
                for (int m = 0; m < matrix1.getNumberColumns(); m++) {
                    sum += matrix1.vectors[i].getComponent(m) * matrix2.vectors[m].getComponent(j);
                }
                saveMatrix.vectors[i].setComponent(j, sum);
            }
        }
        return saveMatrix;
    }
}

