package BottomUpIntegration;

import sqa.lab.DistanceConverter;

public class DriverDistance {
    private DistanceConverter converter = new DistanceConverter();


    public double runGetMultiplier(String fromUnit, String toUnit) {
        return converter.getMultiplier(fromUnit, toUnit);
    }


    public double runConvert(double value, String fromUnit, String toUnit) {
        return converter.convert(value, fromUnit, toUnit);
    }
}