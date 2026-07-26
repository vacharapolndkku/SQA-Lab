package Task2_CompetitionScoreTest;

import Task2_CompetitionScore.CompetitionScore;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class CompetitionScoreTest {

    private CompetitionScore compScore;

    @BeforeEach
    void setUp() {
        compScore = new CompetitionScore();
    }


    // Test Method findMaxScore(int score1, int score2, int score3)


    @ParameterizedTest
    @CsvSource({
        "500, 250, 0, 500",   // TC001: Score1 เป็นค่าสูงสุด
        "0, 500, 250, 500",   // TC002: Score2 เป็นค่าสูงสุด
        "0, 250, 500, 500"    // TC003: Score3 เป็นค่าสูงสุด
    })
    @DisplayName("3 Params: Valid Scores (0-500)")
    void testFindMaxScoreThreeParamsValid(int score1, int score2, int score3, int expectedMax) {
        assertEquals(expectedMax, compScore.findMaxScore(score1, score2, score3));
    }

    @ParameterizedTest
    @CsvSource({
        "-10, 260, 250",  // TC004: Score1 < 0   (I-EC01)
        "600, 260, 250",  // TC005: Score1 > 500 (I-EC02)
        "300, -10, 250",  // TC006: Score2 < 0   (I-EC03)
        "300, 600, 250",  // TC007: Score2 > 500 (I-EC04)
        "300, 260, -10",  // TC008: Score3 < 0   (I-EC05)
        "300, 260, 600"   // TC009: Score3 > 500 (I-EC06)
    })
    @DisplayName("3 Params: Invalid Scores Out of Range (0-500)")
    void testFindMaxScoreThreeParamsInvalid(int score1, int score2, int score3) {
        assertThrows(IllegalArgumentException.class, () -> 
            compScore.findMaxScore(score1, score2, score3)
        );
    }


    // Test Method findMaxScore(int[] scores)

    @ParameterizedTest
    @MethodSource("validArrayProvider")
    @DisplayName("Array: Valid Input (V-EC04)")
    void testFindMaxScoreArrayValid(int[] scores, int expectedMax) {
        assertEquals(expectedMax, compScore.findMaxScore(scores));
    }

    // คืนค่าเป็น Object[][] ธรรมดา ไม่ต้องใช้ Stream
    static Object[][] validArrayProvider() {
        return new Object[][] {
            { new int[]{100, 200, 300}, 300 } // TC010: V-EC04
        };
    }

    @ParameterizedTest
    @MethodSource("invalidArrayProvider")
    @DisplayName("Array: Invalid Length (I-EC08, I-EC09)")
    void testFindMaxScoreArrayInvalidLength(int[] scores) {
        assertThrows(IllegalArgumentException.class, () -> 
            compScore.findMaxScore(scores)
        );
    }

    // คืนค่าเป็น int[][] ธรรมดา สำหรับส่ง Array ความยาวผิดปกติ
    static int[][] invalidArrayProvider() {
        return new int[][] {
            {100, 200, 300, 500}, // TC012: Array ความยาว > 3 (I-EC08)
            {120, 100}            // TC013: Array ความยาว < 3 (I-EC09)
        };
    }

    @ParameterizedTest
    @NullSource // TC011: I-EC07 (Null Array)
    @DisplayName("Array: Null Input (I-EC07)")
    void testFindMaxScoreArrayNull(int[] scores) {
        assertThrows(IllegalArgumentException.class, () -> 
            compScore.findMaxScore(scores)
        );
    }
}