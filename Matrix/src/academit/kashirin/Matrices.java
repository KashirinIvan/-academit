package academit.kashirin;

import academit.kashirin.matrix.Matrix;

public class Matrices {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(4, 5);
        Matrix matrix1= new Matrix(matrix);

        System.out.println(matrix.toString());
        System.out.println(matrix1.toString());
    }
}
