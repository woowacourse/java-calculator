package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import domain.Calculator;

public class CalculatorTest {
	@ParameterizedTest
	@CsvSource(value = {"2 + 3 * 4 / 2,10", "2 + 4 / 2 * 6,18", "-2 + 3 * 4 + -12,-8"})
	@DisplayName("올바른 계산식 결과 값 테스트")
	void calculate(String expression, double expected) {
		assertThat(Calculator.calculate(expression)).isEqualTo(expected);
	}

	@Test
	@DisplayName("0으로 나눌 때 예외가 발생하는지 테스트")
	void testDivideByZero() {
		assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> {
			Calculator.calculate("1 / 0");
		});
	}

	@Test
	@DisplayName("식이 null 이거나 빈 값 일때 테스트")
	void testNullOrEmpty() {
		assertThat(Calculator.calculate("")).isEqualTo(0);
		assertThat(Calculator.calculate(null)).isEqualTo(0);
	}

	@ParameterizedTest
	@ValueSource(strings = {" ", "  ", "   "})
	@DisplayName("식에 공백만 있는 경우 테스트")
	void testBlank(String expression) {
		assertThat(Calculator.calculate(expression)).isEqualTo(0);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,1", "10,10", "100,100", "123,123", "1111,1111"})
	@DisplayName("식에 숫자만 있는 경우 테스트")
	void testOnlyNumber(String expression, double expected) {
		assertThat(Calculator.calculate(expression)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,1", "10,10", "100,100", "123,123", "1111,1111"})
	@DisplayName("식에 숫자만 있는 경우 테스트")
	void testContains(String expression, double expected) {
		assertThat(Calculator.calculate(expression)).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(strings = {"+", "1 + +", "1 + a", "a"})
	@DisplayName("식이 숫자로 끝나지 않을 때 예외 테스트")
	void testNotEndWithNumber(String expression) {
		assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
			Calculator.calculate(expression);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"1 +", "1 + 2 +", "1 + ", "1 + 2 + "})
	@DisplayName("식의 토큰 길이가 올바르지 않을 때 즉 짝수인 경우 예외 테스트")
	void testTokenSize(String expression) {
		assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class).isThrownBy(() -> {
			Calculator.calculate(expression);
		});
	}
}
