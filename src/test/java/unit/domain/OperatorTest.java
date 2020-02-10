package unit.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperatorTest {
	@Test
	void testOperateForPlus() {
		final Number number1 = new Number(1);
		final Number number2 = new Number(2);
		double expected = 3;
		double actual = Operator.PLUS.operate(number1, number2);
		assertEquals(expected, actual);
	}

	@Test
	void testIsInForPlus() {
		final String plus = "+";
		assertTrue(Operator.isIn(plus));
	}

	@Test
	void testOfForPlus() {
		final String plus = "+";
		final Operator expected = Operator.PLUS;
		final Operator actual = Operator.of(plus);
		assertEquals(expected, actual);
	}
}