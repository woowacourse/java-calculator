package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void testSplit() {
		final String value = "1,2";
		final String[] actual = value.split(",");
		assertThat(actual).contains("1");
		assertThat(actual).contains("2");

		final String value2 = "1";
		final String[] actual2 = value2.split(",");
		assertThat(actual2).containsExactly("1");
	}

	@Test
	void testSubstring() {
		final int BRACKET_LENGTH = 1;
		final String value = "(1,2)";
		final String actual = value.substring(BRACKET_LENGTH, value.length() - BRACKET_LENGTH);
		final String expected = "1,2";

		assertThat(actual).isEqualTo(expected);
	}
}
