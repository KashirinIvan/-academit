package academit.kashirin.scale;

import academit.kashirin.InterfaceScale;

public class Fahrenheit implements InterfaceScale {
    private Double inputTemperature;

    @Override
    public void ConvertInCelsius(Double inputTemperature) {
        this.inputTemperature = 5 / 9 * (inputTemperature - 32);
    }

    @Override
    public Double ConvertFromCelsius() {
        if (inputTemperature == null) {
            return null;
        } else {
            return 9 / 5 * inputTemperature + 32;
        }
    }
}
