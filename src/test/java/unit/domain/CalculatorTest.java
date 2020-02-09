package unit.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	private List<Token> tokens;

	@BeforeEach
	void init() {
		tokens = new ArrayList<>();
	}

	@Test
	void testCalculateForThreeTokens() {
		tokens.add(new Number("1"));
		tokens.add(new Operator("+"));
		tokens.add(new Number("2"));
		Expression expression = new Expression(tokens);

		final double expected = 3;
		final double actual = Calculator.calculate(expression);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculateForFiveTokens() {
		tokens.add(new Number("1"));
		tokens.add(new Operator("+"));
		tokens.add(new Number("2"));
		tokens.add(new Operator("/"));
		tokens.add(new Number("2"));

		Expression expression = new Expression(tokens);

		final double expected = 1.5;
		final double actual = Calculator.calculate(expression);
		assertEquals(expected, actual);
	}
}