package unit.util;

import static org.junit.jupiter.api.Assertions.*;
import static unit.util.DoubleHandler.*;

import org.junit.jupiter.api.Test;

class DoubleHandlerTest {
	@Test
	void testRoundForInteger() {
		final double number = 1;
		final String expected = "1";
		final String actual = round(number);
		assertEquals(expected, actual);
	}

	@Test
	void testRoundForRationalNumber() {
		final double number = 1.5;
		final String expected = "1.5";
		final String actual = round(number);
		assertEquals(expected, actual);
	}
}