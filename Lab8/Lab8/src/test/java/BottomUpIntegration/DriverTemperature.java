package BottomUpIntegration;

import sqa.lab.TemperatureConverter;

public class DriverTemperature {
    private TemperatureConverter converter = new TemperatureConverter();

    public double runConvert(double value, String fromUnit, String toUnit) {
        return converter.convert(value, fromUnit, toUnit);
    }
}