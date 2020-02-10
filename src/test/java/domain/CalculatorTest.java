package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorTest {
	private Calculator calculator = new Calculator();

	@ParameterizedTest(name = "{2}")
	@MethodSource("validParameters")
	void validCalculatorTest(String input, double expected, String message) {
		assertThat(calculator.run(input.split(" "))).isEqualTo(expected);
	}

	static Stream<Arguments> validParameters() throws Throwable {
		return Stream.of(
			Arguments.of("1 + 2", 3, "plus works"),
			Arguments.of("1 - 2", -1, "minus works"),
			Arguments.of("2 * 3", 6, "multiply works"),
			Arguments.of("4 / 2", 2, "divide works"),
			Arguments.of("1 + 3 * 4 / 2 - 7 - 3", -2, "many operators work properly")
		);
	}
}
