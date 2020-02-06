package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
	@ParameterizedTest
	@CsvSource(value = {"2 + 3 * 4 / 2,10", "2 + 4 / 2 * 6,18"})
	void calculate(String expression, double expected) {
		String[] values = expression.split(" ");
		assertThat(Calculator.calculate(values)).isEqualTo(expected);
	}
}
