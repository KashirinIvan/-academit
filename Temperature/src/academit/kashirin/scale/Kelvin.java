package academit.kashirin.scale;

import academit.kashirin.Scale;

public class Kelvin implements Scale {
    @Override
    public Double convertToCelsius(Double inputTemperature) {
        if (inputTemperature == null) {
            return null;
        } else {
            return inputTemperature - 273.15;
        }
    }

    @Override
    public Double convertFromCelsius(Double inputTemperature) {
        if (inputTemperature == null) {
            return null;
        } else {
            return inputTemperature + 273.15;
        }
    }
}
