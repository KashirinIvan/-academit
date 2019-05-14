package academit.kashirin.scale;

import academit.kashirin.Scale;

public class Celsius implements Scale {
    @Override
    public Double convertToCelsius(Double inputTemperature) {
        return inputTemperature;
    }

    @Override
    public Double convertFromCelsius(Double inputTemperature) {
        return inputTemperature;
    }
}
