package academit.kashirin.scale;

import academit.kashirin.InterfaceScale;

public class Kelvin implements InterfaceScale {
    private Double inputTemperature;

    @Override
    public void ConvertInCelsius(Double inputTemperature) {
        this.inputTemperature = inputTemperature - 273.15;
    }

    @Override
    public Double ConvertFromCelsius() {
        if (inputTemperature == null) {
            return null;
        } else {
            return inputTemperature + 273.15;
        }
    }
}
