import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
	private InputValidator inputValidator;

	@BeforeEach
	void setUp(){
		inputValidator = new InputValidator();
	}

	@Test
	@DisplayName("입력값을 입력했을 때 제대로된 값으로 재입력 여부를 false 출력")
	void returnFalseIfInputIsValid() {
		assertThat(inputValidator.validate("1 + 2 + 3 + 4.0")).isFalse();
	}

	@Test
	@DisplayName("숫자(0-9) 또는 사칙연산(+,-,*,/) 외의 문자가 들어올 경우 재입력 여부를 true 출력")
	void returnTrueIfInputIncludesInvalidCharacters() {
		assertThat(inputValidator.validate("1 + 2 + 3 + 4.0 + ^")).isTrue();
	}

	@Test
	@DisplayName("입력값의 마지막 값이 사칙연산(+,-,*,/) 일 때 재입력 여부를 true 출력")
	void returnTrueIfInputEndsWithOperator() {
		assertThat(inputValidator.validate("1 + 2 + 3 + 4.0 +")).isTrue();
	}

	@Test
	@DisplayName("입력값의 첫번째 값이 사칙연산(+,-,*,/) 일 때 재입력 여부를 true 출력")
	void returnTrueIfInputStartsWithOperator() {
		assertThat(inputValidator.validate("+ 1 - 5 / 6")).isTrue();
	}

	@Test
	@DisplayName("공백없이 숫자(0-9)와 연산자(+,-,*,/)가 연속으로 붙어 있는 경우 재입력 여부를 true 출력")
	void returnTrueIfSplittedInputStartsWithInvalidOperator() {
		assertThat(inputValidator.validate("1 + *3 + /2 + 3 + 3")).isTrue();
	}

	@Test
	@DisplayName("공백없이 숫자(0-9)사이에 연산자(+,-,*,/)가 들어가 있을 경우 재입력 여부를 true 출력")
	void returnTrueIfSplittedInputElementContainsNumberAndOperator() {
		assertThat(inputValidator.validate("1+2 + 123")).isTrue();
	}

	@Test
	@DisplayName("숫자(0-9)와 연산자(+,-,*,/)가 공백을 기준으로 반복적으로 들어올 경우 재입력 여부를 true 출력")
	void returnTrueIfNumberOrOperatorRepeats() {
		assertThat(inputValidator.validate("1 1 - 2 + + 3")).isTrue();
	}

	@Test
	@DisplayName("0으로 나누기를 수행하는 경우 재입력 여부를 true 출력")
	void returnTrueIfZeroDivisionExists() {
		assertThat(inputValidator.validate("1 + 2 / 0")).isTrue();
	}

	@Test
	@DisplayName("double값의 범위가 넘어가는 값이 들어올 경우 재입력 여부를 true 출력")
	void returnTrueIfInputExceedsRangeOfDouble() {
		assertThat(inputValidator.validate(Double.MAX_VALUE + "+ 2")).isTrue();
	}

	@AfterEach
	void tearDown(){
		inputValidator = null;
	}
}
