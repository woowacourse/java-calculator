package unit.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

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
}