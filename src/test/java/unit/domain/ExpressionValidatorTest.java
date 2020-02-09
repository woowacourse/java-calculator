package unit.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static unit.domain.ExpressionValidator.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpressionValidatorTest {
	private static final int INDEX_OF_NUMBER_TURN = 0;
	private static final int INDEX_OF_OPERATOR_TURN = 1;

	private List<Token> tokens;

	@BeforeEach
	void init() {
		tokens = new ArrayList<>();
	}

	@Test
	void testCheckValidationForInsufficientSizeOfTokens() {
		tokens.add(new Number("1"));
		tokens.add(new Operator("+"));

		assertThatIllegalArgumentException().isThrownBy(() ->
			checkValidation(tokens)
		).withMessage("식은 최소 3자 이상이어야 합니다.");
	}

	@Test
	void testCheckValidationForUnbalancedTokens() {
		tokens.add(new Number("1"));
		tokens.add(new Operator("+"));
		tokens.add(new Number("1"));
		tokens.add(new Operator("+"));

		assertThatIllegalArgumentException().isThrownBy(() ->
			checkValidation(tokens)
		).withMessage("연산자 혹은 숫자의 개수가 너무 많습니다.");
	}

	@Test
	void testIsNumberTurn() {
		assertTrue(isNumberTurn(INDEX_OF_NUMBER_TURN));
		assertFalse(isNumberTurn(INDEX_OF_OPERATOR_TURN));
	}

	@Test
	void testIsOperatorTurn() {
		assertTrue(isOperatorTurn(INDEX_OF_OPERATOR_TURN));
		assertFalse(isOperatorTurn(INDEX_OF_NUMBER_TURN));
	}
}
