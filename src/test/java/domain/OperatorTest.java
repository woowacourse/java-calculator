package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperatorTest {
	private Operator operator = new Operator();

	@ParameterizedTest
	@CsvSource(value = {"5:3:8", "3:2:5"}, delimiter = ':')
	void add(int number1, int number2, int expected) {
		assertThat(operator.add(number1, number2)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"5:3:2", "3:2:1"}, delimiter = ':')
	void subtract(int number1, int number2, int expected) {
		assertThat(operator.subtract(number1, number2)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"5:3:15", "3:2:6"}, delimiter = ':')
	void multiply(int number1, int number2, int expected) {
		assertThat(operator.multiply(number1, number2)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"6:3:2", "3:1:3"}, delimiter = ':')
	void divide(int number1, int number2, int expected) {
		assertThat(operator.divide(number1, number2)).isEqualTo(expected);
	}

	@Test
	@DisplayName("Divide with 0 test")
	void divideWithZero() {
		assertThatThrownBy(() -> operator.divide(10, 0))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("0으로 나누지 마시오.");
	}
}