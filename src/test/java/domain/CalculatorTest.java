package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {
	private Calculator calculator;

	@BeforeEach
	void setup() {
		calculator = new Calculator();
	}

	@ParameterizedTest
	@CsvSource(value = {"1 + 2 * 3 / 4:2", "1 + 3 + 3 / 4:1", "3 + 4:7", "11 + 57 - 10:58", "1 - 10:-9"}, delimiter = ':')
	public void applyTest(String expression, int expected) {
		int actual = calculator.calculate(expression);
		assertThat(actual).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1 + k * 3 ; 4", "1 3 3 * 3 / 4", "+ + 3 * 3 ; 4", "1 + 3 * 3 / 4 +", "+"})
	public void applyExceptionTest(String expression) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> calculator.calculate(expression));
	}
}