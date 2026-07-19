package Lab4Task2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import health.fitness.HealthIndexScore;

public class Lab4Task2 {
    //Test เพิ่มที่ min-,max+ ของ vo2Max, restingHeartRate, heartRateRecovery อีก 6 เคส
	@Test	 
	public void testRobustnessException() {
		//TC014: vo2Max = -1 (min-), rhr = 80, hrr = 15
		HealthIndexScore HealthRobustnessTest;
		assertThrows(IllegalArgumentException.class, () -> { new HealthIndexScore(-1.0, 80, 15);}, 
															"TC001 VO2 Max cannot be negative.");
		
		//TC015 : vo2Max = 61, rhr = 80, hrr = 15
		HealthRobustnessTest = new HealthIndexScore(61.0, 80, 15);
        assertEquals(11, HealthRobustnessTest.getTotalScore(), "TC006 Total Score");
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, HealthRobustnessTest.getFitnessLevel(), "TC006 Fitness Level");
        
        //TC016: vo2Max = 30, rhr = 39 (min-), hrr = 15
        assertThrows(IllegalArgumentException.class, () -> { new HealthIndexScore(30.0, 39, 15);}, 
															"TC007 Resting Heart Rate (RHR) must be between 40 and 220 bpm.");
               
        //TC017: vo2Max = 30, rhr = 221 (max+), hrr = 15
        assertThrows(IllegalArgumentException.class, () -> { new HealthIndexScore(30.0, 221, 15);}, 
															"TC012 Resting Heart Rate (RHR) must be between 40 and 220 bpm.");
        
        //TC018: vo2Max = 30, rhr = 80, hrr = -1 (min-)
        assertThrows(IllegalArgumentException.class, () -> { new HealthIndexScore(30.0, 80, -1);}, 
															"TC013 Heart Rate Recovery (HRR) cannot be negative.");
        
        //TC019: vo2Max = 30, rhr = 80, hrr = 26 (max+)
        HealthRobustnessTest = new HealthIndexScore(30.0, 80, 26);
        assertEquals(9, HealthRobustnessTest.getTotalScore(), "TC014 Total Score");
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, HealthRobustnessTest.getFitnessLevel(), "TC018 Fitness Level");
       }
	@Test
    public void testNormalBoundaryValues() {
        HealthIndexScore HealthNormalTest;

        // TC001: vo2=0.0 (min-), rhr=80, hrr=15
        HealthNormalTest = new HealthIndexScore(0.0, 80, 15);
        assertEquals(6, HealthNormalTest.getTotalScore(), "TC001 Total Score");
		assertEquals(HealthIndexScore.FitnessLevel.STANDARD, HealthNormalTest.getFitnessLevel(), "TC001 Fitness Level");
        // TC002: vo2=1.0 (min), rhr=80, hrr=15
        HealthNormalTest = new HealthIndexScore(1.0, 80, 15);
        assertEquals(6, HealthNormalTest.getTotalScore(), "TC002 Total Score");
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, HealthNormalTest.getFitnessLevel(), "TC002 Fitness Level");

        // TC003: vo2=59.0 (max-), rhr=80, hrr=15
        HealthNormalTest = new HealthIndexScore(59.0, 80, 15);
        assertEquals(10, HealthNormalTest.getTotalScore(), "TC003 Total Score");
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, HealthNormalTest.getFitnessLevel(), "TC003 Fitness Level");

        // TC004: vo2=60.0 (max), rhr=80, hrr=15
        HealthNormalTest = new HealthIndexScore(60.0, 80, 15);
        assertEquals(10, HealthNormalTest.getTotalScore(), "TC004 Total Score");
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, HealthNormalTest.getFitnessLevel(), "TC004 Fitness Level");

        // TC005: vo2=30.0, rhr=40 (min), hrr=15
        HealthNormalTest = new HealthIndexScore(30.0, 40, 15);
        assertEquals(9, HealthNormalTest.getTotalScore(), "TC005 Total Score");
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, HealthNormalTest.getFitnessLevel(), "TC005 Fitness Level");

        // TC006: vo2=30.0, rhr=41 (min+), hrr=15
        HealthNormalTest = new HealthIndexScore(30.0, 41, 15);
        assertEquals(9, HealthNormalTest.getTotalScore(), "TC006 Total Score");
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, HealthNormalTest.getFitnessLevel(), "TC006 Fitness Level");

        // TC007: vo2=30.0, rhr=219 (max-), hrr=15
        HealthNormalTest = new HealthIndexScore(30.0, 219, 15);
        assertEquals(5, HealthNormalTest.getTotalScore(), "TC007 Total Score");
        assertEquals(HealthIndexScore.FitnessLevel.POOR, HealthNormalTest.getFitnessLevel(), "TC007 Fitness Level");

        // TC008: vo2=30.0, rhr=220 (max), hrr=15
        HealthNormalTest = new HealthIndexScore(30.0, 220, 15);
        assertEquals(5, HealthNormalTest.getTotalScore(), "TC008 Total Score");
        assertEquals(HealthIndexScore.FitnessLevel.POOR, HealthNormalTest.getFitnessLevel(), "TC008 Fitness Level");

        // TC009: vo2=30.0, rhr=80, hrr=0 (min)
        HealthNormalTest = new HealthIndexScore(30.0, 80, 0);
        assertEquals(5, HealthNormalTest.getTotalScore(), "TC009 Total Score");
        assertEquals(HealthIndexScore.FitnessLevel.POOR, HealthNormalTest.getFitnessLevel(), "TC009 Fitness Level");

        // TC010: vo2=30.0, rhr=80, hrr=1 (min+)
        HealthNormalTest = new HealthIndexScore(30.0, 80, 1);
        assertEquals(5, HealthNormalTest.getTotalScore(), "TC010 Total Score");
        assertEquals(HealthIndexScore.FitnessLevel.POOR, HealthNormalTest.getFitnessLevel(), "TC010 Fitness Level");

        // TC011: vo2=30.0, rhr=80, hrr=24 (max-)
        HealthNormalTest = new HealthIndexScore(30.0, 80, 24);
        assertEquals(8, HealthNormalTest.getTotalScore(), "TC011 Total Score");
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, HealthNormalTest.getFitnessLevel(), "TC011 Fitness Level");

        // TC012: vo2=30.0, rhr=80, hrr=25 (max)
        HealthNormalTest = new HealthIndexScore(30.0, 80, 25);
        assertEquals(9, HealthNormalTest.getTotalScore(), "TC012 Total Score");
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, HealthNormalTest.getFitnessLevel(), "TC012 Fitness Level");

        // TC013: vo2=30.0, rhr=80, hrr=15 (nom)
        HealthNormalTest = new HealthIndexScore(30.0, 80, 15);
        assertEquals(7, HealthNormalTest.getTotalScore(), "TC013 Total Score");
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, HealthNormalTest.getFitnessLevel(), "TC013 Fitness Level");
    }
	

	}
	
		

