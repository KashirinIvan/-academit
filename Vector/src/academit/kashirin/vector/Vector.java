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
            this.component = new double[n];
            if (component.length >= 0) {
                System.arraycopy(component, 0, this.component, 0, component.length);
            }
        }
    }

    public int getSize(){
        return 1;
    }
    
    @Override
    public String toString() {
        return Arrays.toString(component);

    }
}
