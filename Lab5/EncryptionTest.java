package Task1_EncryptionTest;

import Task1_ShiftCypher.ShiftCipher;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;


import static org.junit.jupiter.api.Assertions.*;

public class EncryptionTest {

    private ShiftCipher cipher;

    @BeforeEach
    void setUp() {
        cipher = new ShiftCipher();
    }

    // Valid Cases
    
    @ParameterizedTest
    @CsvSource({
        "ABC, 3, DEF" // TC007: Valid Input
    })
    @DisplayName("Encrypt: Valid Input (V-EC01, V-EC02)")
    void testEncryptValid(String plainText, int key, String expected) {
        assertEquals(expected, cipher.encrypt(plainText, key));
    }

    // Invalid Cases

    @ParameterizedTest
    @ValueSource(strings = {
        "123", // TC001: Numbers (I-EC01)
        "A B"  // TC002: Space (I-EC02)
    })
    @DisplayName("Encrypt: Invalid String Input (I-EC01, I-EC02, I-EC03)")
    void testEncryptInvalidText(String plainText) {
        assertThrows(IllegalArgumentException.class, () -> cipher.encrypt(plainText, 3)
        );
    }

    @ParameterizedTest
    @NullAndEmptySource // TC003: Null (I-EC06)
    @DisplayName("Encrypt: Null or Empty Input (I-EC06)")
    void testEncryptNullOrEmpty(String plainText) {
        assertThrows(IllegalArgumentException.class, () -> 
            cipher.encrypt(plainText, 3)
        );
    }
}