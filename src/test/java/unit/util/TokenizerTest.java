package unit.util;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tokenizer test")
class TokenizerTest {

	@DisplayName("tokenize test")
	@Test
	void testTokenize() {
		final String inputLine = "1 + 2";
		final List<String> actual = Tokenizer.tokenize(inputLine);
		final List<String> expected = new ArrayList<>();
		expected.add("1");
		expected.add("+");
		expected.add("2");

		assertThat(actual).isEqualTo(expected);
	}
}