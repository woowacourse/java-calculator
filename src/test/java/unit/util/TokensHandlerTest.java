package unit.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unit.domain.Number;
import unit.domain.Numbers;
import unit.domain.Operators;

class TokensHandlerTest {
	List<String> tokens = new ArrayList<>();

	@BeforeEach
	void init() {
		tokens.add("1");
		tokens.add("+");
		tokens.add("2");
		tokens.add("-");
		tokens.add("3");
	}

	@Test
	void testToNumbers() {
		final Stack<Number> numbers = new Stack<>();
		numbers.push(new Number(3));
		numbers.push(new Number(2));
		numbers.push(new Number(1));

		final Numbers expected = new Numbers(numbers);
		final Numbers actual = TokensHandler.toNumbers(tokens);
		assertEquals(expected, actual);
	}

	@Test
	void testToExpression() {
		final Stack<String> operators = new Stack<>();
		operators.push("-");
		operators.push("+");

		final Operators expected = new Operators(operators);
		final Operators actual = TokensHandler.toOperators(tokens);
		assertEquals(expected, actual);
	}
}