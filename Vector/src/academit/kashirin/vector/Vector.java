package academit.kashirin.vector;

import java.util.Arrays;
import java.util.StringJoiner;


public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n должно быть > 0");
        }
        this.components = new double[n];
    }

    public Vector(Vector ob) {
        this.components = Arrays.copyOf(ob.components, ob.components.length);
    }

    public Vector(double[] component) {
        if (component.length == 0) {
            throw new IllegalArgumentException("Массив должен быть > 0");
        }
        this.components = Arrays.copyOf(component, component.length);
    }

    public Vector(int n, double[] component) {
        if (n <= 0) {
            throw new IllegalArgumentException("n должно быть > 0");
        }
        this.components = Arrays.copyOf(component, n);
    }

    public int getSize() {
        return this.components.length;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (double element : components) {
            joiner.add(Double.toString(element));
        }
        return joiner.toString();
    }

    public void sum(Vector vector1) {
        int maxLength = Math.max(getSize(), vector1.getSize());
        double[] saveArray = Arrays.copyOf(this.components, maxLength);
        this.components = new double[maxLength];
        for (int i = 0; i < maxLength; i++) {
            this.components[i] = saveArray[i] + vector1.components[i];
        }
    }

    public void difference(Vector vector1) {
        int maxLength = Math.max(getSize(), vector1.getSize());
        double[] saveArray = Arrays.copyOf(this.components, maxLength);
        this.components = new double[maxLength];
        for (int i = 0; i < maxLength; i++) {
            this.components[i] = saveArray[i] - vector1.components[i];
        }
    }

    public void multiplication(double scalar) {
        for (int i = 0; i < getSize(); i++) {
            this.components[i] *= scalar;
        }
    }

    public void expand() {
        multiplication(-1);
    }

    public double getLength() {
        double length = 0;
        for (double element : this.components) {
            length += Math.pow(element, 2);
        }
        return Math.sqrt(length);
    }

    public double getComponent(int index) {
        return this.components[index];
    }

    public void setComponent(int index, double value) {
        this.components[index] = value;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Vector p = (Vector) o;
        if (p.getSize() != getSize()) {
            return false;
        }
        for (int i = 0; i < components.length; i++) {
            if (components[i] != p.components[i]) {
                return false;
            }
        }
        return true;
    }

    public static Vector sum(Vector vector1, Vector vector2) {
        Vector saveArray = new Vector(vector1);
        saveArray.sum(vector2);
        return saveArray;
    }

    public static Vector difference(Vector vector1, Vector vector2) {
        Vector saveArray = new Vector(vector1);
        saveArray.difference(vector2);
        return saveArray;
    }

    public static double getMultiplication(Vector vector1, Vector vector2) {
        int minLength = Math.min(vector1.components.length, vector2.components.length);
        double scalar = 0;
        for (int i = 0; i < minLength; i++) {
            scalar += vector1.components[i] * vector2.components[i];
        }
        return scalar;
    }
}
