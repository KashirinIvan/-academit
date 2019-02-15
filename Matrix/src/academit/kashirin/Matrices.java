package academit.kashirin;

import academit.kashirin.matrix.Matrix;
import academit.kashirin.vector.Vector;

public class Matrices {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(4, 5);
        Matrix matrix1 = new Matrix(matrix);
        Matrix matrix2 = new Matrix(new double[][]{{2.2, 23, 43.4, 3}, {23, 3.4, 5, 67, 5}});
        Matrix matrix3 = new Matrix(new Vector[]{(new Vector(new double[]{4, 45, 5.6, 42, 7, 9})), (new Vector(new double[]{3, 4.5, 4, 67, 5}))});

        System.out.println(matrix.toString());
        System.out.println(matrix1.toString());
        System.out.println(matrix2.toString());
        System.out.println(matrix3.toString());

        System.out.println(matrix.getSizeN());
        System.out.println(matrix.getSizeM());

        System.out.println(matrix3.getLineVectorByIndex(1));

        matrix2.setLineVectorByIndex(1, (new Vector(new double[]{4, 45, 5.6, 7, 9})));
        System.out.println(matrix2.toString());

        System.out.println(matrix3.getColumnVectorByIndex(2));

        matrix2.transposition();
        System.out.println(matrix2.toString());

        matrix3.multiplication(3);
        System.out.println(matrix3.toString());
    }
}
