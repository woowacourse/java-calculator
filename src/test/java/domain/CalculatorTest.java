package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	private Calculator calculator = new Calculator();

	@Test
	void plus() {
		Assertions.assertThat(calculator.calculate("1 + 2".split(" "))).isEqualTo(3);
	}

	@Test
	void minus() {
		Assertions.assertThat(calculator.calculate("1 - 2".split(" "))).isEqualTo(-1);
	}

	@Test
	void multiply() {
		Assertions.assertThat(calculator.calculate("2 * 3".split(" "))).isEqualTo(6);
	}

	@Test
	void divide() {
		Assertions.assertThat(calculator.calculate("4 / 2".split(" "))).isEqualTo(2);
	}

	@Test
	void manyOperatorsWorksProperly() {
		Assertions.assertThat(calculator.calculate("1 + 3 * 4 / 2 - 7 - 3".split(" "))).isEqualTo(-2);
	}

	@Test
	void zeroDivisionInvokesException() {
		Assertions.assertThat(calculator.calculate("1 + 2".split(" "))).isEqualTo(3);
	}
}
