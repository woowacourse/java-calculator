package unit.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Operator test")
class OperatorTest {
	@DisplayName("operator test")
	@Test
	void testOperator() {
		final String invalidValue = "%";
		assertThatThrownBy(() -> {
			new Operator(invalidValue);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("유효한 연산자 형식이 아닙니다.");
	}

	@DisplayName("calculate test")
	@Test
	void testCalculate() {
		Operator plus = new Operator("+");
		final Number one = new Number("1");
		final Number two = new Number("2");

		final double expected = 3;
		final double actual = plus.calculate(one, two);

		assertThat(actual).isEqualTo(expected);

		Operator divide = new Operator("/");
		final Number zero = new Number("0");

		assertThatThrownBy(() -> {
			divide.calculate(one, zero);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage(("0 으로 나눌 수 없습니다."));

		final double expected2 = 0.5;
		final double actual2 = divide.calculate(one, two);

		assertThat(actual2).isEqualTo(expected2);
	}
}