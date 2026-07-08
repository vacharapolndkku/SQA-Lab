import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CaesarCipher.ShiftCipher;

class Lab3Task1JunitTest {
	private final ShiftCipher cipher = new ShiftCipher(); 
	@Test
	void TC01() {
		assertEquals("ZVMADHYL", cipher.shift("SOFTWARE", 3));
	}
	@Test
	void TC02() {
		assertEquals("zvmadhyl", cipher.shift("software", 3));
	}

	@Test
	void TC03() {
		assertEquals("PPZ", cipher.shift("KKU", 5));
	}
	
	@Test
	void TC04() {
		assertEquals("invalid", cipher.shift("1234", 3));
	}

}
