package TopDownIntegration;

import sqa.lab.WeightConverter;

public class WeightConverterStub extends WeightConverter {
	@Override
	public double convert(double weightValue, String fromUnit, String toUnit) {
		return 120.0;
	}

}
