package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import util.ExpressionParser;

public class ExpressionParserTest {
	@Test
	void removeBlank() {
		String values = "1 + 2   + 3";
		String expected = "1+2+3";
		Assertions.assertThat(ExpressionParser.removeBlank(values)).isEqualTo(expected);
	}
}
