package TopDownIntegration;

import sqa.lab.DistanceConverter;

public class DistanceMultiplierStub extends DistanceConverter {
    // จำลองเฉพาะ getMultiplier
    @Override
    public double getMultiplier(String fromUnit, String toUnit) {

        return 1075.0; 
    }
}