package academit.kashirin.matrix;

import academit.kashirin.vector.Vector;

import java.util.StringJoiner;

public class Matrix {
    private Vector[] rows;

    public Matrix(int columnsNumber, int rowsNumber) {
        if (columnsNumber == 0 || rowsNumber == 0) {
            throw new IllegalArgumentException("Размер матрицы должен быть отличен от 0");
        }
        this.rows = new Vector[rowsNumber];

        for (int i = 0; i < rowsNumber; i++) {
            this.rows[i] = new Vector(columnsNumber);
        }
    }

    public Matrix(Matrix matrix) {
        this.rows = new Vector[matrix.getRowsNumber()];

        for (int i = 0; i < matrix.getRowsNumber(); i++) {
            this.rows[i] = new Vector(matrix.rows[i]);
        }
    }

    public Matrix(double[][] array) {
        if (array.length == 0 && array[0].length == 0) {
            throw new IllegalArgumentException("Размер матрицы должен быть отличен от 0");
        }

        this.rows = new Vector[array.length];
        int maxLength = array.length;

        for (double[] component : array) {
            if (component.length > maxLength) {
                maxLength = component.length;
            }
        }

        for (int i = 0; i < array.length; i++) {
            this.rows[i] = new Vector(maxLength, array[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        if (vectors.length == 0) {
            throw new IllegalArgumentException("Размер матрицы должен быть отличен от 0");
        }
        this.rows = new Vector[vectors.length];
        int maxLength = vectors.length;

        for (Vector component : vectors) {
            if (component.getSize() > maxLength) {
                maxLength = component.getSize();
            }
        }

        for (int i = 0; i < vectors.length; i++) {
            double[] save = new double[vectors[i].getSize()];
            for (int j = 0; j < vectors[i].getSize(); j++) {
                save[j] = vectors[i].getComponent(j);
            }
            this.rows[i] = new Vector(maxLength, save);
        }
    }

    public int getColumnsNumber() {
        return this.rows[0].getSize();
    }

    public int getRowsNumber() {
        return this.rows.length;
    }

    public Vector getRow(int index) {
        if ((index >= getRowsNumber()) || (index < 0)) {
            throw new IndexOutOfBoundsException("Строки с таким индексом не существует");
        }
        return new Vector(this.rows[index]);

    }

    public void setRow(int index, Vector vector) {
        if ((index >= getRowsNumber()) || index < 0) {
            throw new IndexOutOfBoundsException("Строки с таким индексом не существует");
        }
        if (vector.getSize() != getColumnsNumber()) {
            throw new IllegalArgumentException("Размерность вектора не верна");
        }
        this.rows[index] = new Vector(vector);
    }

    public Vector getColumn(int index) {
        if ((index >= getColumnsNumber()) || index < 0) {
            throw new IndexOutOfBoundsException("Столбца с таким индексом не существует");
        }
        Vector columnByIndex = new Vector(rows.length);
        for (int i = 0; i < rows.length; i++) {
            columnByIndex.setComponent(i, rows[i].getComponent(index));
        }
        return columnByIndex;
    }

    public void transposition() {
        Vector[] arrayRows = new Vector[getColumnsNumber()];
        for (int i = 0; i < getColumnsNumber(); i++) {
            arrayRows[i] = getColumn(i);
        }
        this.rows = arrayRows;
    }

    public void multiplication(double scalar) {
        for (Vector element : this.rows) {
            element.multiplication(scalar);
        }
    }

    public double getDeterminant() {
        if (getColumnsNumber() != getRowsNumber()) {
            throw new IllegalArgumentException("Матрица не квадратная");
        }
        if (getColumnsNumber() == 1) {
            return this.rows[0].getComponent(0);
        }
        double determinant = 0.0;
        if (getColumnsNumber() == 2) {
            determinant = this.rows[0].getComponent(0) * this.rows[1].getComponent(1) - this.rows[1].getComponent(0) * this.rows[0].getComponent(1);
        } else {
            int coefficient;
            for (int i = 0; i < getColumnsNumber(); i++) {
                if (i % 2 == 1) {
                    coefficient = -1;
                } else {
                    coefficient = 1;
                }
                determinant += coefficient * this.rows[0].getComponent(i) * getMinor(this, i).getDeterminant();
            }
        }
        return determinant;
    }

    private Matrix getMinor(Matrix matrix, int column) {
        int minorLength = matrix.getRowsNumber() - 1;
        Matrix minor = new Matrix(minorLength, minorLength);
        int dI = 0;
        for (int i = 0; i <= minorLength; i++) {
            int dJ = 0;
            for (int j = 0; j <= minorLength; j++) {
                if (i == 0) {
                    dI = 1;
                } else {
                    if (j == column) {
                        dJ = 1;
                    } else {
                        minor.rows[i - dI].setComponent((j - dJ), matrix.rows[i].getComponent(j));
                    }
                }
            }
        }
        return minor;
    }


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (Vector element : rows) {
            joiner.add(element.toString());
        }
        return joiner.toString();
    }

    public Vector multiplicationByVector(Vector vector) {
        if (getColumnsNumber() != vector.getSize()) {
            throw new IllegalArgumentException("Количество столбцов матрицы не равно количеству строк вектора");
        }
        Vector result = new Vector(getRowsNumber());
        for (int i = 0; i < getRowsNumber(); i++) {
            double sum = 0;
            for (int j = 0; j < getColumnsNumber(); j++) {
                sum += this.rows[i].getComponent(j) * vector.getComponent(j);
            }
            result.setComponent(i, sum);
        }
        return result;
    }

    public void sum(Matrix matrix) {
        if (getColumnsNumber() != matrix.getColumnsNumber()) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы не равно количеству столбцов второй матрицы");
        }
        if (getRowsNumber() != matrix.getRowsNumber()) {
            throw new IllegalArgumentException("Количество строк первой матрицы не равно количеству строк второй матрицы");
        }
        for (int i = 0; i < getRowsNumber(); i++) {
            for (int j = 0; j < getColumnsNumber(); j++) {
                rows[i].setComponent(j, rows[i].getComponent(j) + matrix.rows[i].getComponent(j));
            }
        }
    }

    public void difference(Matrix matrix) {
        if (getColumnsNumber() != matrix.getColumnsNumber()) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы не равно количеству столбцов второй матрицы");
        }
        if (getRowsNumber() != matrix.getRowsNumber()) {
            throw new IllegalArgumentException("Количество строк первой матрицы не равно количеству строк второй матрицы");
        }
        for (int i = 0; i < getRowsNumber(); i++) {
            for (int j = 0; j < getColumnsNumber(); j++) {
                rows[i].setComponent(j, rows[i].getComponent(j) - matrix.rows[i].getComponent(j));
            }
        }
    }

    public static Matrix sum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsNumber() != matrix2.getColumnsNumber()) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы не равно количеству столбцов второй матрицы");
        }
        if (matrix1.getRowsNumber() != matrix2.getRowsNumber()) {
            throw new IllegalArgumentException("Количество строк первой матрицы не равно количеству строк второй матрицы");
        }
        Matrix saveMatrix = new Matrix(matrix1);
        saveMatrix.sum(matrix2);
        return saveMatrix;
    }

    public static Matrix difference(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsNumber() != matrix2.getColumnsNumber()) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы не равно количеству столбцов второй матрицы");
        }
        if (matrix1.getRowsNumber() != matrix2.getRowsNumber()) {
            throw new IllegalArgumentException("Количество строк первой матрицы не равно количеству строк второй матрицы");
        }
        Matrix saveMatrix = new Matrix(matrix1);
        saveMatrix.difference(matrix2);
        return saveMatrix;
    }

    public static Matrix multiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsNumber() != matrix2.getRowsNumber()) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы не равно количеству строк второй матрицы");
        }
        Matrix saveMatrix = new Matrix(matrix2.getColumnsNumber(), matrix1.getRowsNumber());
        for (int i = 0; i < matrix1.getRowsNumber(); i++) {
            for (int j = 0; j < matrix2.getColumnsNumber(); j++) {
                double sum = 0;
                for (int m = 0; m < matrix1.getColumnsNumber(); m++) {
                    sum += matrix1.rows[i].getComponent(m) * matrix2.rows[m].getComponent(j);
                }
                saveMatrix.rows[i].setComponent(j, sum);
            }
        }
        return saveMatrix;
    }
}

