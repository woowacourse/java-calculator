package unit.util;

import static org.junit.jupiter.api.Assertions.*;
import static unit.util.TokensHandler.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

import unit.domain.Token;
import unit.domain.Number;
import unit.domain.Operator;

class TokensHandlerTest {
	@Test
	void testToExpression() {
		final List<Token> tokens = new ArrayList<>();
		tokens.add(new Number("1"));
		tokens.add(new Operator("+"));
		tokens.add(new Number("2"));

		final Stack<Token> expected = new Stack<>();
		Collections.reverse(tokens);
		tokens.forEach(expected::push);

		final Stack<Token> actual = toExpression(expected);

		assertEquals(expected, actual);
	}
}