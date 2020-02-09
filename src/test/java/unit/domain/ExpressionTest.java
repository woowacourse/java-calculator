package unit.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpressionTest {
	private Expression expression;

	@BeforeEach
	void init() {
		List<Token> tokens = new ArrayList<>();
		tokens.add(new Number("1"));
		tokens.add(new Operator("+"));
		tokens.add(new Number("2"));
		expression = new Expression(tokens);
	}

	@Test
	void testIsSizeEqualTo() {
		final int three = 3;
		assertTrue(expression.isSizeGreaterThanOrEqualTo(three));
	}

	@Test
	void testIsSizeGreaterThan() {
		final int two = 2;
		assertTrue(expression.isSizeGreaterThanOrEqualTo(two));
	}
}