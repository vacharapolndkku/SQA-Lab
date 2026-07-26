package Task1_DecryptionTest;

import Task1_ShiftCypher.ShiftCipher;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class DecryptionTest {

    private ShiftCipher cipher;

    @BeforeEach
    void setUp() {
        cipher = new ShiftCipher();
    }

    // Valid Cases

    @ParameterizedTest
    @CsvSource({
        "ABC, 3, XYZ" // TC007: Valid Input
    })
    @DisplayName("Decrypt: Valid Input (V-EC01, V-EC02)")
    void testDecryptValid(String cipherText, int key, String expected) {
        assertEquals(expected, cipher.decrypt(cipherText, key));
    }

    // Invalid Cases

    @ParameterizedTest
    @ValueSource(strings = {
        "123", // TC001: Numbers (I-EC01)
        "A B"  // TC002: Space (I-EC02)
    })
    @DisplayName("Decrypt: Invalid String Input (I-EC01, I-EC02)")
    void testDecryptInvalidText(String cipherText) {
        assertThrows(IllegalArgumentException.class, () -> 
            cipher.decrypt(cipherText, 3)
        );
    }

    @ParameterizedTest
    @NullAndEmptySource // TC003: Null or Empty (I-EC06)
    @DisplayName("Decrypt: Null or Empty Input (I-EC06)")
    void testDecryptNullOrEmpty(String cipherText) {
        assertThrows(IllegalArgumentException.class, () -> 
            cipher.decrypt(cipherText, 3)
        );
    }
}