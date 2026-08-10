package EEDT;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import sqa.lab.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EEDT {

    private final QuadraticEquation eq = new QuadraticEquation();

    @ParameterizedTest(name = "a={0}, b={1}, c={2} => expect {3}")
    @CsvFileSource(resources = "/Valid_TestData_EEDT.csv") 
    void RootNature_Valid_LEDT(int a, int b, int c, RootNature expected) {
        
        RootNature actual = eq.determineRootNature(a, b, c);
        assertEquals(expected, actual, "TC_EEDT_Valid: a=" + a + ", b=" + b + ", c=" + c);
    }
    @ParameterizedTest(name = "a={0}, b={1}, c={2}")
    @CsvFileSource(resources = "/Invalid_TestData_EEDT.csv")
    void Invalid_LEDT(int a,int b,int c) {
		assertThrows(IllegalArgumentException.class, () -> eq.determineRootNature(a, b, c), "EEDT_Invalid: a=" + a + ", b=" + b + ", c=" + c);
		
		//IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {eq.determineRootNature(a, b, c);}); 
        //System.out.println("Error message : " + exception.getMessage()); //ไว้ดู error message
	}
}