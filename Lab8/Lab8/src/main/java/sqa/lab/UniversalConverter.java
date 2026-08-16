package sqa.lab;

/*
 * Lab assignment#8 Integration testing
 * 
 * Convert value in one unit to other units
 * 
 * @author Asst.Prof. Chitsutha Soomlek, College of Computing, KKU
 * @version 1.1
 * 
 */
public class UniversalConverter {

    private DistanceConverter distanceConverter = new DistanceConverter();
    private WeightConverter weightConverter = new WeightConverter();
    private TemperatureConverter tempConverter = new TemperatureConverter();
    
    // Constructor
    public UniversalConverter() {
        
    }
    
    // Setters for injecting stubs in integration testing
    public void setDistanceConverter(DistanceConverter distanceConverter) {
        this.distanceConverter = distanceConverter;
    }

    public void setWeightConverter(WeightConverter weightConverter) {
        this.weightConverter = weightConverter;
    }

    public void setTempConverter(TemperatureConverter tempConverter) {
        this.tempConverter = tempConverter;
    }

    /*
     * Convert a value from one unit to another unit
     * 
     * @parameter value = the value to convert
     * @parameter choice = selected choice (what to convert)
     * @parameter fromUnit = the unit of the value, e.g, meter
     * @parameter toUnit = the unit to convert the value to, e.g., kilometer
     * @return the converted value
     */
    public double convert(double value, String choice, String fromUnit, String toUnit) {
        double result = 0.0;
        
        
        if (choice.equals("Distance")) {
            result = distanceConverter.convert(value, fromUnit, toUnit);
        } else if (choice.equals("Weight")) {
            result = weightConverter.convert(value, fromUnit, toUnit);
        } else if (choice.equals("Temperature")) {
            result = tempConverter.convert(value, fromUnit, toUnit);
        }
            
        return result;
    }
}