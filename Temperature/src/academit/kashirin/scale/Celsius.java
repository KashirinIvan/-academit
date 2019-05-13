package academit.kashirin.scale;

import academit.kashirin.InterfaceScale;

public class Celsius implements InterfaceScale {

    @Override
    public Double ConvertInCelsius(Double inputTemperature) {
        if (inputTemperature == null) {
            return null;
        } else {
            return inputTemperature;
        }
    }

    @Override
    public Double ConvertFromCelsius(Double inputTemperature) {
        if (inputTemperature == null) {
            return null;
        } else {
            return inputTemperature;
        }
    }
}
