package academit.kashirin.scale;

import academit.kashirin.Scale;

public class Celsius implements Scale {
    @Override
    public Double convertToCelsius(Double inputTemperature) {
        if (inputTemperature == null) {
            return null;
        } else {
            return inputTemperature;
        }
    }

    @Override
    public Double convertFromCelsius(Double inputTemperature) {
        if (inputTemperature == null) {
            return null;
        } else {
            return inputTemperature;
        }
    }
}
