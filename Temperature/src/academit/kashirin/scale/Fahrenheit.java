package academit.kashirin.scale;

import academit.kashirin.Scale;

public class Fahrenheit implements Scale {
    @Override
    public Double convertToCelsius(Double inputTemperature) {
        if (inputTemperature == null) {
            return null;
        } else {
            return ((double) 5 / 9) * (inputTemperature - 32);
        }
    }

    @Override
    public Double convertFromCelsius(Double inputTemperature) {
        if (inputTemperature == null) {
            return null;
        } else {
            return ((double) 9 / 5) * inputTemperature + 32;
        }
    }
}
