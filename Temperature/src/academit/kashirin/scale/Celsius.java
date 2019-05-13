package academit.kashirin.scale;

import academit.kashirin.InterfaceScale;

public class Celsius implements InterfaceScale {
    private Double inputTemperature;

    @Override
    public void ConvertInCelsius(Double inputTemperature) {
        this.inputTemperature = inputTemperature;
    }

    @Override
    public Double ConvertFromCelsius() {
        if (inputTemperature == null) {
            return null;
        } else {
            return inputTemperature;
        }
    }
}
