package academit.kashirin;

import academit.kashirin.matrix.Matrix;
import academit.kashirin.vector.Vector;

public class Matrices {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(4, 5);
        Matrix matrix1 = new Matrix(matrix);
        Matrix matrix2 = new Matrix(new double[][]{{2.2, 23, 43.4, 3, 5}, {23, 3.4, 5, 67, 5, 6}});
        Matrix matrix3 = new Matrix(new Vector[]{(new Vector(new double[]{4, 45, 5.6, 42, 7, 9})), (new Vector(new double[]{3, 4.5, 4, 67, 5}))});

        System.out.println(matrix.toString());
        System.out.println(matrix1.toString());
        System.out.println(matrix2.toString());
        System.out.println(matrix3.toString());

        System.out.println(matrix.getNumberColumns());
        System.out.println(matrix.getNumberRows());

        System.out.println(matrix3.getRow(1));

        matrix2.setRow(1, (new Vector(new double[]{5, 45, 5.6, 7, 9.4, 6})));
        System.out.println(matrix2.toString());

        System.out.println(matrix3.getColumn(2));

        Matrix matrix15 = new Matrix(new double[][]{{3.2, 24}, {4.4, 9}});
        matrix15.transposition();
        System.out.println(matrix15.toString());

        matrix3.multiplication(3);
        System.out.println(matrix3.toString());

        Matrix matrix13 = new Matrix((new double[][]{{11, -2}, {7, 5}}));
        System.out.println(matrix13.getDeterminant());

        Matrix matrix14 = new Matrix((new double[][]{{3, 3, -1, 5}, {4, 1, 3, 6}, {1, -2, -2, 7}, {56, -2, -2, 7}}));
        System.out.println(matrix14.getDeterminant());

        Vector result = new Vector(new double[]{5.2, 6.4, 56, 41, 2, 21});
        result = matrix3.multiplicationByVector(result);
        System.out.println(result.toString());

        matrix3.sum(matrix3);
        System.out.println(matrix3.toString());

        Matrix matrix6 = new Matrix(new double[][]{{2.2, 23, 43.4, 3, 5}, {23, 3.4, 5, 67, 5, 6}});
        Matrix matrix7 = new Matrix(new double[][]{{3.2, 24, 44.4, 4, 6}, {24, 4.4, 6, 68, 6, 7}});

        matrix6.difference(matrix7);
        System.out.println(matrix6.toString());

        Matrix matrix8 = new Matrix(new double[][]{{2.2, 23, 43.4, 3, 5}, {23, 3.4, 5, 67, 5, 6}});
        Matrix matrix9 = new Matrix(new double[][]{{2.2, 23, 43.4, 3, 5}, {23, 3.4, 5, 67, 5, 6}});

        Matrix matrix4 = Matrix.sum(matrix8, matrix9);
        System.out.println(matrix4.toString());

        Matrix matrix5 = Matrix.difference(matrix8, matrix9);
        System.out.println(matrix5.toString());

        Matrix matrix10 = new Matrix(new double[][]{{2.2, 23, 4}, {23, 3.4, 5}});
        Matrix matrix11 = new Matrix(new double[][]{{2.2, 23, 43.4, 3, 5}, {23, 3.4, 5, 67, 6}, {23, 3.4, 5, 67, 6}});

        Matrix matrix12 = Matrix.multiplication(matrix10, matrix11);
        System.out.println(matrix12.toString());

    }
}
