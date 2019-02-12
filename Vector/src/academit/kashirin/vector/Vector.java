package academit.kashirin.vector;

import java.util.Arrays;

public class Vector {
    private double[] component;

    public Vector(int n) {
        this.component = new double[n];
    }

    public Vector(Vector ob) {
        this.component = ob.component;
    }

    public Vector(double[] component) {
        this.component = component;
    }

    public Vector(int n, double[] component) {
        if (component.length >= n) {
            this.component = component;
        } else {

        }
    }

    @Override
    public String toString() {
        return "{" + component + "}";
    }
}
