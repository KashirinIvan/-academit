package academit.kashirin.matrix;

import academit.kashirin.vector.Vector;

import java.util.Arrays;
import java.util.StringJoiner;

import static java.lang.System.arraycopy;

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
        arraycopy(ob.component, 0, this.component, 0, ob.component.length);
    }

    public Matrix(double[][] component) {
        this.component = new Vector[component.length];
        for (int i = 0; i < component.length; i++) {
            this.component[i] = new Vector(component[i]);
        }
    }

    public Matrix(Vector[] component) {
        this.component = new Vector[component.length];
        for (int i = 0; i < component.length; i++) {
            this.component[i] = new Vector(component[i]);
        }
    }

  /*  public getSizeMatrix(){

    }
*/
    public Vector getLineVectorByIndex(int index){
        return this.component[index];
    }

    public void setLineVectorByIndex(int index, Vector vector){

        this.component[index] = new Vector(vector);
    }
    public Vector getColumnVectorByIndex(int index) {
        Vector columnByIndex = new Vector(component.length);
        for (int i = 0; i < component.length; i++) {
            columnByIndex.setComponentVector(i, component[i].getComponentVector(index));
        }
        return columnByIndex;
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(",", "{", "}");
        Arrays.stream(component).forEach(element -> joiner.add(element + " "));
        return joiner.toString();
    }
}
