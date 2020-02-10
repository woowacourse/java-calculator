package unit.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static unit.util.TokensValidator.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TokensValidatorTest {
	private List<String> tokens;

	@BeforeEach
	void init() {
		tokens = new ArrayList<>();
	}

	@Test
	void testCheckValidationForInsufficientSizeOfTokens() {
		tokens.add("1");
		tokens.add("+");

		assertThatIllegalArgumentException().isThrownBy(() ->
			checkValidation(tokens)
		).withMessage("식은 최소 3자 이상이어야 합니다.");
	}

	@Test
	void testCheckValidationForEndWithOperatorTokens() {
		tokens.add("1");
		tokens.add("+");
		tokens.add("1");
		tokens.add("+");

		assertThatIllegalArgumentException().isThrownBy(() ->
			checkValidation(tokens)
		).withMessage("식의 마지막은 연산자가 될수 없습니다.");
	}

	@Test
	void testCheckValidationForUnbalancedTokens() {
		tokens.add("1");
		tokens.add("1");
		tokens.add("+");
		tokens.add(("1"));

		assertThatThrownBy(() ->
			checkValidation(tokens)
		).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("연산자 혹은 숫자의 개수가 너무 많습니다.");
	}

	@Test
	void testIsNumberForNumber() {
		final String token = "123";
		assertTrue(isNumber(token));
	}
	@Test
	void testIsNumberForOperator() {
		final String token = "+";
		assertFalse(isNumber(token));
	}
}
