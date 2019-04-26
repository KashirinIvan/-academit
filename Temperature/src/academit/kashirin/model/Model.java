package academit.kashirin.model;

public class Model {
    private double inputTemperature;
    private int inputScale;
    private int outputScale;

    public void setInput(double input) {
        this.inputTemperature = input;
    }

    public double getOutput() {
        if (inputScale == outputScale) {
            return inputTemperature;
        } else if ((inputScale == 0) && (outputScale == 1)) {
            return inputTemperature + 273.15;
        } else if ((inputScale == 0) && (outputScale == 2)) {
            return inputTemperature * 9 / 5 + 32;
        } else if ((inputScale == 1) && (outputScale == 0)) {
            return inputTemperature - 273.15;
        } else if ((inputScale == 1) && (outputScale == 2)) {
            return (inputTemperature - 273.15) * 9 / 5 + 32;
        } else if ((inputScale == 2) && (outputScale == 0)) {
            return (inputTemperature - 32) * 5 / 9;
        } else {
            return (inputTemperature - 32) * 5 / 9 + 273.15;
        }
    }

    public void setInputScale(int scale) {
        this.inputScale = scale;
    }

    public void setOutputScale(int scale) {
        this.outputScale = scale;
    }
}
