package academit.kashirin.scale;

import academit.kashirin.InterfaceScale;

public class Fahrenheit implements InterfaceScale {

    @Override
    public Double ConvertInCelsius(Double inputTemperature) {
        if (inputTemperature == null) {
            return null;
        } else {
            return ((double) 5 / 9) * (inputTemperature - 32);
        }
    }

    @Override
    public Double ConvertFromCelsius(Double inputTemperature) {
        if (inputTemperature == null) {
            return null;
        } else {
            return ((double) 9 / 5) * inputTemperature + 32;
        }
    }
}
