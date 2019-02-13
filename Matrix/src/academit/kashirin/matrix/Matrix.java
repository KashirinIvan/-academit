package academit.kashirin.matrix;

import academit.kashirin.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] component;

    public Matrix(int n, int m) {
        this.component = new Vector[m];
        for (int i = 0; i < m; i++) {
            this.component[i] = new Vector(n);
        }
    }

    public Matrix(Matrix ob) {
        this.component = new Vector[ob.component.length];
        System.arraycopy(ob.component, 0, this.component, 0, ob.component.length);
    }

    public Matrix (double[][] component){
        this.component = new Vector[]
    }

    public Matrix (Vector[] component){

    }
    public String toString() {
        return Arrays.toString(component);
    }

}
