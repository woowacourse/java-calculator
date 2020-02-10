package unit.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperatorsTest {
	private Stack<String> values = new Stack<>();
	private Operators operators;

	@BeforeEach
	void init() {
		values.push("+");
		values.push("-");
		operators = new Operators(values);
	}

	@Test
	void testPush() {
		final String divide = "/";
		final int sizeOfInitialValues = values.size();
		values.push(divide);

		assertEquals(values.size(), sizeOfInitialValues + 1);
		assertThat(values.pop()).isEqualTo(divide);
	}

	@Test
	void testPop() {
		final String expected = "-";
		final String actual = operators.pop();
		assertEquals(expected, actual);
	}

	@Test
	void testSize() {
		final int expected = 2;
		final int actual = operators.size();
		assertEquals(expected, actual);
	}
}