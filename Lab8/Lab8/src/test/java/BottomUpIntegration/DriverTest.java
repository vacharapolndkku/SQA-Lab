package BottomUpIntegration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import sqa.lab.UniversalConverter;

public class DriverTest {

    // =========================================================================
    // กิ่ง Distance (เริ่มจากล่างขึ้นบน)
    // =========================================================================

    @Test
    void testDriver_DistanceMultiplier() {
        // ใช้ Driver ที่เราสร้างขึ้นมา
        DriverDistance driver = new DriverDistance();
        
        // ให้ Driver เรียกใช้ getMultiplier
        double actualResult = driver.runGetMultiplier("kilometer", "meter");
        assertEquals(1000.0, actualResult, 0.01);
    }

    @Test
    void testDriver_DistanceConvert() {
        DriverDistance driver = new DriverDistance();
        
        // ให้ Driver เรียกใช้ convert
        double actualResult = driver.runConvert(1, "kilometer", "meter");
        assertEquals(1000.0, actualResult, 0.01);
    }

    // =========================================================================
    // Weight
    // =========================================================================

    @Test
    void testDriver_WeightMultiplier() {
        DriverWeight driver = new DriverWeight();
        
        double actualResult = driver.runGetMultiplier("kilogram", "lbs");
        assertEquals(2.205, actualResult, 0.001);
    }

    @Test
    void testDriver_WeightConvert() {
        DriverWeight driver = new DriverWeight();
        
        double actualResult = driver.runConvert(1, "kilogram", "lbs");
        assertEquals(2.205, actualResult, 0.001);
    }

    // =========================================================================
    // Temperature
    // =========================================================================

    @Test
    void testDriver_TemperatureConvert() {
        DriverTemperature driver = new DriverTemperature();
        
        double actualResult = driver.runConvert(10, "K", "C");
        assertEquals(-263.15, actualResult, 0.01);
    }
    
    // =========================================================================
    // ระดับบนสุด (Universal) 
    // =========================================================================
    
    @Test
    void testDriver_Universal() {

        UniversalConverter uc = new UniversalConverter();
        
        double actualResult = uc.convert(1, "Distance", "kilometer", "meter");
        assertEquals(1000.0, actualResult, 0.01);
    }
    
 // =========================================================================
    // กิ่ง Weight (เทสเคสที่จงใจให้เจอ Defect)
    // =========================================================================

    @Test
    void testDriver_WeightMultiplier_KgToGram() {
        DriverWeight driver = new DriverWeight();
        
        double actualResult = driver.runGetMultiplier("kilogram", "gram");
        

        assertEquals(1000.0, actualResult, 0.01); 
    }

    @Test
    void testDriver_WeightConvert_OunceToGram() {
        DriverWeight driver = new DriverWeight();
        

        double actualResult = driver.runConvert(1, "ounce", "gram");
        

        assertEquals(28.35, actualResult, 0.01);
    }
}