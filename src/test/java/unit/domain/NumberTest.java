package unit.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberTest {
	@Test
	void testGetNumber() {
		Number one = new Number(1);

		final double expected = 1;
		final double actual = one.getNumber();
		assertEquals(expected, actual);
	}

	@Test
	void testEquals() {
		Number one1 = new Number(1);
		Number one2 = new Number(1);

		assertEquals(one1, one2);
	}
}