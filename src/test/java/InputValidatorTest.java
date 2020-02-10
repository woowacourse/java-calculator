import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InputValidatorTest {
	private InputValidator inputValidator = new InputValidator();

	@Test
	void returnFalseIfInputIsValid() {
		assertThat(inputValidator.isNotValid("1 + 2 + 3 + 4.0")).isFalse();
	}

	@ParameterizedTest(name = "{1}")
	@MethodSource("invalidParameters")
	void returnTrueIfInputIsInvalid(String input, String message) {
		assertThat(inputValidator.isNotValid(input)).isTrue();
	}

	static Stream<Arguments> invalidParameters() throws Throwable {
		return Stream.of(
			Arguments.of("1 + 2 + 3 + 4.0 + ^", "If Input Includes Invalid Character"),
			Arguments.of("1 + 2 + 3 + 4.0 +", "If Input Ends With Operator"),
			Arguments.of("+ 1 - 5 / 6", "If Input Starts With Operator"),
			Arguments.of("1 + *3 + /2 + 3 + 3", "If Splitted Input Starts With Invalid Operator"),
			Arguments.of("1+2 + 123", "If Splitted Input Element Contains Number And Operator"),
			Arguments.of("1 1 - 2 + + 3", "If Number Or Operator Repeats"),
			Arguments.of("1 + 2 / 0", "If Zero Division Exists"),
			Arguments.of("Double.MAX_VALUE + \"+ 2", "If Input Exceeds Range Of Double")
		);
	}
}
