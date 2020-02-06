package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import util.ExpressionParser;

public class ExpressionParserTest {
	@Test
	void splitExpression() {
		String values = "1 + 2 + 3";
		String[] expected = {"1", "+", "2", "+", "3"};
		String[] notExpected = {"1", "+", "2", "3"};
		Assertions.assertThat(ExpressionParser.splitWithBlank(values)).isEqualTo(expected);
		Assertions.assertThat(ExpressionParser.splitWithBlank(values)).isNotEqualTo(notExpected);
	}

	@Test
	void isNumber() {
		String[] expected = {"123", "-123"};
		String[] notExpected = {"- 123", "123asd", "-"};

		for (String testTerm: expected) {
			Assertions.assertThat(ExpressionParser.isNumber(testTerm)).isTrue();
		}

		for (String testTerm: notExpected) {
			Assertions.assertThat(ExpressionParser.isNumber(testTerm)).isFalse();
		}
	}
}
