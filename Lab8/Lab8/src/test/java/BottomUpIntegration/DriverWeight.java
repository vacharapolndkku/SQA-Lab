package BottomUpIntegration;

import sqa.lab.WeightConverter;

public class DriverWeight {
    private WeightConverter converter = new WeightConverter();

    public double runGetMultiplier(String fromUnit, String toUnit) {
        return converter.getMultiplier(fromUnit, toUnit);
    }

    public double runConvert(double value, String fromUnit, String toUnit) {
        return converter.convert(value, fromUnit, toUnit);
    }
}