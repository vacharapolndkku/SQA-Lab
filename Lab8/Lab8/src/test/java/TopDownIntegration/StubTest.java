package TopDownIntegration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import sqa.lab.UniversalConverter;

public class StubTest {

    @Test
    public void testStep1_UniversalToConvertStub() {
        UniversalConverter uc = new UniversalConverter();
        
        uc.setDistanceConverter(new DistanceConverterStub());
        
        double actualResult = uc.convert(1.0, "Distance", "kilometer", "meter");
        
        assertEquals(111.0, actualResult, 0.01);
    }

    @Test
    public void testStep2_UniversalToMultiplierStub() {
        UniversalConverter uc = new UniversalConverter();
        
        uc.setDistanceConverter(new DistanceMultiplierStub());
        
        double actualResult = uc.convert(2.0, "Distance", "kilometer", "meter");
        
        assertEquals(2000.0, actualResult, 0.01);
    }

    @Test
    public void testStep3_FullDistanceBranch() {
        UniversalConverter uc = new UniversalConverter();
        
        double actualResult = uc.convert(5.0, "Distance", "kilometer", "meter");
        
        assertEquals(5000.0, actualResult, 0.01);
    }
}