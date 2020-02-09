package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

	@ParameterizedTest
	@CsvSource(value = {"1 + 2 + 3,6", "4 * 2 + 7 / 5,3", "-1 + 2 + 8 / 5,1.8"})
	void calculate(String expression, double expected) {
		assertThat(Calculator.calculate(expression)).isEqualTo(expected);
	}

}
