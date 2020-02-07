package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {
	private Calculator calculator;

	@BeforeEach
	void setup() {
		calculator = new Calculator();
	}

	@Test
	public void numericCheckExceptionTest() throws Exception {
	    String expression = "1 + 3 * a / 4";
		String[] array = expression.split(" ");

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> calculator.validateNumericPosition(array));
	}

	@Test
	public void operatorCheckExceptionTest() throws Exception {
		String expression = "1 + 3 * 3 ;";
		String[] array = expression.split(" ");

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> calculator.validateOperatorPosition(array));
	}

	@ParameterizedTest
	@ValueSource(strings = {"1 + k * 3 ; 4", "1 3 3 * 3 / 4", "+ + 3 * 3 ; 4", "1 + 3 * 3 / 4 +", "+"})
	public void validateExpressionExceptionTest(String expressionInput) throws Exception {
		String[] expressionArray = expressionInput.split(" ");
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> calculator.validateFormula(expressionArray));
	}

	@ParameterizedTest
	@CsvSource(value = {"1,true" ,"3,true", "5,true", "a,false", "b,false"}, delimiter = ',')
	public void isNumericTest(String value, boolean expected) throws Exception {
	    assertThat(calculator.isNumeric(value)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"1 + 2 * 3 / 4:2", "1 + 3 + 3 / 4:1", "3 + 4:7", "11 + 57 - 10:58", "1 - 10:-9"}, delimiter = ':')
	public void getApplyResultTest(String expression, int expected) throws Exception {
		String[] expressionAsArray = expression.split(" ");
		int actual = calculator.getApplyResult(expressionAsArray);
		assertThat(actual).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"1 + 2 * 3 / 4:2", "1 + 3 + 3 / 4:1", "3 + 4:7", "11 + 57 - 10:58", "1 - 10:-9"}, delimiter = ':')
	public void applyTest(String expression, int expected) throws Exception {
		int actual = calculator.apply(expression);
		assertThat(actual).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1 + k * 3 ; 4", "1 3 3 * 3 / 4", "+ + 3 * 3 ; 4", "1 + 3 * 3 / 4 +", "+"})
	public void applyExceptionTest(String expression) throws Exception {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> calculator.apply(expression));
	}
}