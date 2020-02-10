package unit.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	private Numbers numbers;
	private Operators operators;

	@BeforeEach
	void init() {
		numbers = new Numbers(new Stack<>());
		operators = new Operators(new Stack<>());
	}

	@Test
	void testCalculateForThreeTokens() {
		numbers.push(new Number(1));
		operators.push("+");
		numbers.push(new Number(2));

		final double expected = 3;
		final double actual = Calculator.calculate(numbers, operators);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculateForFiveTokens() {
		numbers.push(new Number(2));
		operators.push("/");
		numbers.push(new Number(2));
		operators.push("+");
		numbers.push(new Number(1));

		final double expected = 1.5;
		final double actual = Calculator.calculate(numbers, operators);
		assertEquals(expected, actual);
	}
}