package unit.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

class TokensTest {
	@Test
	void testTokens() {
		List<Token> invalidTokens = Arrays.asList(new Number("1"), new Operator("+"), new Operator("+"));
		assertThatThrownBy(() -> {
			new Tokens(invalidTokens);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("잘못된 식입니다.");
	}

	@Test
	void testGetExpression() {
		List<Token> value = Arrays.asList(new Number("1"), new Operator("+"), new Number("2"));
		Tokens tokens = new Tokens(value);
		Stack<Token> actual = tokens.getExpression();
		Stack<Token> expected = new Stack<>();
		expected.push(new Number("2"));
		expected.push(new Operator("+"));
		expected.push(new Number("1"));
		assertThat(actual).isEqualTo(expected);
	}
}