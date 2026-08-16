package TopDownIntegration;

import sqa.lab.DistanceConverter;

public class DistanceConverterStub extends DistanceConverter {
	@Override
	public double convert(double distanceValue, String fromUnit, String toUnit) {
		return 111.0;
	}

}
