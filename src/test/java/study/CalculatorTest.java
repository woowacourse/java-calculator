package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.Calculator;

public class CalculatorTest {
	@ParameterizedTest
	@CsvSource(value = {"2 + 3 * 4 / 2,10", "2 + 4 / 2 * 6,18", "-2 + 3 * 4 + -12,-8"})
	void calculate(String expression, double expected) {
		String[] values = expression.split(" ");
		assertThat(Calculator.calculate(values)).isEqualTo(expected);
	}

	@Test
	@DisplayName("0으로 나눌 때 예외가 발생하는지 테스트")
	void testZeroDivide() {
		String[] values = "1 / 0".split(" ");
		assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> {
			Calculator.calculate(values);
		}).withMessage("0으로 나눌 수 없습니다.");
	}
}
