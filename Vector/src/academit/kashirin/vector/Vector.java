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
        this.components = new double[ob.components.length];
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
        for (String element : (String[])(components)) {
            joiner.add(element);
        }
        return joiner.toString();
    }

    public void sum(Vector ob) {
        if (getSize() >= ob.components.length) {
            double[] saveArray = Arrays.copyOf(ob.components, getSize());
            for (int i = 0; i < getSize(); i++) {
                this.components[i] += saveArray[i];
            }
        } else {
            double[] saveArray = Arrays.copyOf(this.components, getSize());
            this.components = Arrays.copyOf(saveArray, ob.components.length);
            for (int i = 0; i < getSize(); i++) {
                this.components[i] += ob.components[i];
            }
        }
    }

    public void difference(Vector ob) {
        if (getSize() >= ob.components.length) {
            double[] saveArray = Arrays.copyOf(ob.components, getSize());
            for (int i = 0; i < getSize(); i++) {
                this.components[i] -= saveArray[i];
            }
        } else {
            double[] saveArray = Arrays.copyOf(this.components, getSize());
            this.components = Arrays.copyOf(saveArray, ob.components.length);
            for (int i = 0; i < getSize(); i++) {
                this.components[i] -= ob.components[i];
            }
        }
    }

    public void multiplication(double scalar) {
        for (int i = 0; i < getSize(); i++) {
            this.components[i] *= scalar;
        }
    }

    public void reversal() {
        for (int i = 0; i < getSize(); i++) {
            this.components[i] *= -1;
        }
    }

    public double length() {
        double length = 0;
        for (int i = 0; i < getSize(); i++) {
            length += Math.pow(this.components[i], 2);
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
        for (int i = 0; i < components.length; i++) {
            if (components[i] != p.components[i]) {
                return false;
            }
        }
        return true;
    }

    public static Vector sumVector(Vector ob, Vector ob1) {
        if (ob.components.length >= ob1.components.length) {
            Vector saveArray = new Vector(ob.components.length);
            for (int i = 0; i < ob.components.length; i++) {
                saveArray.components[i] = ob.components[i] + ob1.components[i];
            }
            return saveArray;
        } else {
            Vector saveArray = new Vector(ob1.components.length);
            for (int i = 0; i < ob1.components.length; i++) {
                saveArray.components[i] = ob.components[i] + ob1.components[i];
            }
            return saveArray;
        }
    }

    public static Vector differenceVector(Vector ob, Vector ob1) {
        if (ob.components.length >= ob1.components.length) {
            Vector saveArray = new Vector(ob.components.length);
            for (int i = 0; i < ob.components.length; i++) {
                saveArray.components[i] = ob.components[i] - ob1.components[i];
            }
            return saveArray;
        } else {
            Vector saveArray = new Vector(ob1.components.length);
            for (int i = 0; i < ob1.components.length; i++) {
                saveArray.components[i] = ob.components[i] - ob1.components[i];
            }
            return saveArray;
        }
    }

    public static Vector multiplicationVector(Vector ob, double scalar) {
        Vector saveArray = new Vector(ob.components.length);
        for (int i = 0; i < ob.components.length; i++) {
            saveArray.components[i] = ob.components[i] * scalar;
        }
        return saveArray;
    }
}
