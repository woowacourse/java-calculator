import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {
	private InputValidator inputValidator = new InputValidator();

	@Test
	void returnFalseIfInputIsValid() {
		assertThat(inputValidator.validate("1 + 2 + 3 + 4.0")).isFalse();
	}

	@Test
	void returnTrueIfInputIncludesInvalidCharacters() {
		assertThat(inputValidator.validate("1 + 2 + 3 + 4.0 + ^")).isTrue();
	}

	@Test
	void returnTrueIfInputEndsWithOperator() {
		assertThat(inputValidator.validate("1 + 2 + 3 + 4.0 +")).isTrue();
	}

	@Test
	void returnTrueIfInputStartsWithOperator() {
		assertThat(inputValidator.validate("+ 1 - 5 / 6")).isTrue();
	}

	@Test
	void returnTrueIfSplittedInputStartsWithInvalidOperator() {
		assertThat(inputValidator.validate("1 + *3 + /2 + 3 + 3")).isTrue();
	}

	@Test
	void returnTrueIfSplittedInputElementContainsNumberAndOperator() {
		assertThat(inputValidator.validate("1+2 + 123")).isTrue();
	}

	@Test
	void returnTrueIfNumberOrOperatorRepeats() {
		assertThat(inputValidator.validate("1 1 - 2 + + 3")).isTrue();
	}

	@Test
	void returnTrueIfZeroDivisionExists() {
		assertThat(inputValidator.validate("1 + 2 / 0")).isTrue();
	}

	@Test
	void returnTrueIfInputExceedsRangeOfDouble() {
		assertThat(inputValidator.validate(Double.MAX_VALUE + "+ 2")).isTrue();
	}
}
