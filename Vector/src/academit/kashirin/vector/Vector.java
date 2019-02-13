package academit.kashirin.vector;

import java.util.Arrays;
import java.util.StringJoiner;

public class Vector {
    private double[] component;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n должно быть > 0");
        }
        this.component = new double[n];
    }

    public Vector(Vector ob) {
        this.component = new double[ob.component.length];
        System.arraycopy(ob.component, 0, this.component, 0, ob.component.length);
    }

    public Vector(double[] component) {
        if (component.length == 0) {
            throw new IllegalArgumentException("Массив должен быть > 0");
        }
        this.component = new double[component.length];
        System.arraycopy(component, 0, this.component, 0, component.length);
    }

    public Vector(int n, double[] component) {
        if (n <= 0) {
            throw new IllegalArgumentException("n должно быть > 0");
        }
        if (component.length == 0) {
            throw new IllegalArgumentException("Массив должен быть > 0");
        }
        if (component.length >= n) {
            this.component = component;
        } else {
            this.component = new double[n];
            System.arraycopy(component, 0, this.component, 0, component.length);
        }
    }

    public int getSize() {
        return this.component.length;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",", "{", "}");
        Arrays.stream(component).forEach(element -> joiner.add(element + " "));
        return joiner.toString();
    }

    public void sumVector(Vector ob) {
        if (getSize() >= ob.component.length) {
            double[] saveArray = new double[getSize()];
            System.arraycopy(ob.component, 0, saveArray, 0, ob.component.length);
            for (int i = 0; i < getSize(); i++) {
                this.component[i] += saveArray[i];
            }
        } else {
            double[] saveArray = new double[getSize()];
            System.arraycopy(this.component, 0, saveArray, 0, this.component.length);
            this.component = new double[ob.component.length];
            System.arraycopy(saveArray, 0, this.component, 0, saveArray.length);
            for (int i = 0; i < getSize(); i++) {
                this.component[i] += ob.component[i];
            }
        }
    }

    public void differenceVector(Vector ob) {
        if (getSize() >= ob.component.length) {
            double[] saveArray = new double[getSize()];
            System.arraycopy(ob.component, 0, saveArray, 0, ob.component.length);
            for (int i = 0; i < getSize(); i++) {
                this.component[i] -= saveArray[i];
            }
        } else {
            double[] saveArray = new double[getSize()];
            System.arraycopy(this.component, 0, saveArray, 0, this.component.length);
            this.component = new double[ob.component.length];
            System.arraycopy(saveArray, 0, this.component, 0, saveArray.length);
            for (int i = 0; i < getSize(); i++) {
                this.component[i] -= ob.component[i];
            }
        }
    }

    public void multiplicationVector(double scalar) {
        for (int i = 0; i < getSize(); i++) {
            this.component[i] *= scalar;
        }
    }

    public void reversalVector() {
        for (int i = 0; i < getSize(); i++) {
            this.component[i] *= -1;
        }
    }

    public double lengthVector() {
        double length = 0;
        for (int i = 0; i < getSize(); i++) {
            length += Math.pow(this.component[i], 2);
        }
        return Math.sqrt(length);
    }

    public double getComponentVector(int index) {
        return this.component[index];
    }

    public void setComponentVector(int index, double value) {
        this.component[index] = value;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(component);
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
        for (int i = 0; i < component.length; i++) {
            if (component[i] != p.component[i]) {
                return false;
            }
        }
        return true;
    }

    public static Vector sumVector(Vector ob, Vector ob1) {
        if (ob.component.length >= ob1.component.length) {
            Vector saveArray = new Vector(ob.component.length);
            for (int i = 0; i < ob.component.length; i++) {
                saveArray.component[i] = ob.component[i] + ob1.component[i];
            }
            return saveArray;
        } else {
            Vector saveArray = new Vector(ob1.component.length);
            for (int i = 0; i < ob1.component.length; i++) {
                saveArray.component[i] = ob.component[i] + ob1.component[i];
            }
            return saveArray;
        }
    }

    public static Vector differenceVector(Vector ob, Vector ob1) {
        if (ob.component.length >= ob1.component.length) {
            Vector saveArray = new Vector(ob.component.length);
            for (int i = 0; i < ob.component.length; i++) {
                saveArray.component[i] = ob.component[i] - ob1.component[i];
            }
            return saveArray;
        } else {
            Vector saveArray = new Vector(ob1.component.length);
            for (int i = 0; i < ob1.component.length; i++) {
                saveArray.component[i] = ob.component[i] - ob1.component[i];
            }
            return saveArray;
        }
    }

    public static Vector multiplicationVector(Vector ob, double scalar) {
        Vector saveArray = new Vector(ob.component.length);
        for (int i = 0; i < ob.component.length; i++) {
            saveArray.component[i] = ob.component[i] * scalar;
        }
        return saveArray;

    }

}
