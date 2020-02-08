package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ExpressionTest {
	private Calculator calculator;

	@BeforeEach
	void setup() {
		calculator = new Calculator();
	}

	@ParameterizedTest
	@CsvSource(value = {"10:10", "1 + 2 * 3 / 4:2", "1 + 3 + 3 / 4:1", "3 + 4:7", "11 + 57 - 10:58", "1 - 10:-9"}, delimiter = ':')
	public void calculateTest(String expression, int expected) {
		Expression parsedExpression = ExpressionParser.parseExpression(expression);
		int actual = calculator.calculate(parsedExpression);
		assertThat(actual).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1 + k * 3 ; 4", "1 3 3 * 3 / 4", "+ + 3 * 3 ; 4", "1 + 3 * 3 / 4 +", "+"})
	public void calculateExceptionTest(String expression) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> ExpressionParser.parseExpression(expression));
	}

	@ParameterizedTest
	@ValueSource(strings = {"1 + 5 * 3 / 0", "1 / 0", "0 / 0", "1 / 0 * 3 / 4"})
	public void calculateDivideExceptionTest(String expression) {
		Expression dividedByZeroExpression = ExpressionParser.parseExpression(expression);
		assertThatExceptionOfType(ArithmeticException.class)
			.isThrownBy(() -> calculator.calculate(dividedByZeroExpression));
	}
}