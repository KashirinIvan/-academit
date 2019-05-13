package academit.kashirin.scale;

import academit.kashirin.InterfaceScale;

public class Kelvin implements InterfaceScale {

    @Override
    public Double ConvertInCelsius(Double inputTemperature) {
        if (inputTemperature == null) {
            return null;
        } else {
            return inputTemperature - 273.15;
        }
    }

    @Override
    public Double ConvertFromCelsius(Double inputTemperature) {
        if (inputTemperature == null) {
            return null;
        } else {
            return inputTemperature + 273.15;
        }
    }
}
