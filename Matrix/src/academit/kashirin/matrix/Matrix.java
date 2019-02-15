package academit.kashirin.matrix;

import academit.kashirin.vector.Vector;

import java.util.Arrays;
import java.util.StringJoiner;

public class Matrix {
    private Vector[] components;

    public Matrix(int n, int m) {
        this.components = new Vector[m];
        for (int i = 0; i < m; i++) {
            this.components[i] = new Vector(n);
        }
    }

    public Matrix(Matrix ob) {
        this.components = new Vector[ob.components.length];
        this.components = Arrays.copyOf(ob.components, ob.components.length);
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
        return this.components[index];
    }

    public void setLineVectorByIndex(int index, Vector vector) {
        this.components[index] = new Vector(vector);
    }

    public Vector getColumnVectorByIndex(int index) {
        Vector columnByIndex = new Vector(components.length);
        for (int i = 0; i < components.length; i++) {
            columnByIndex.setComponent(i, components[i].getComponent(index));
        }
        return columnByIndex;
    }

    public void transposition() {

    }

    public void multiplication(double scalar) {
        for (int i = 0; i < getSizeM(); i++) {
            this.components[i].multiplication(scalar);
        }
    }

    public double getDeterminant() {
        double determinant = 0;

        return determinant;
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (Vector element : components) {
            joiner.add(element.toString());
        }
        return joiner.toString();
    }
}
