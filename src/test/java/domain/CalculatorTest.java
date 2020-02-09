package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTest {
	@ParameterizedTest
	@MethodSource("generateInput")
	@DisplayName("계산 기능 테스트")
	public void calculateTest(List<String> inputs, double expectedValue) {
		Calculator calculator = new Calculator(inputs);
		double result = calculator.calculate();
		assertThat(result).isEqualTo(expectedValue);
	}

	static Stream<Arguments> generateInput() {
		return Stream.of(Arguments.of(Arrays.asList("1", "+", "3", "*", "5"), 20.0D),
			Arguments.of(Arrays.asList("1", "*", "3", "/", "3"), 1.0D),
			Arguments.of(Arrays.asList("5", "/", "2", "*", "2"), 5.0D));
	}
}