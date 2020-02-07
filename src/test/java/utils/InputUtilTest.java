package utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputUtilTest {
	@ParameterizedTest
	@MethodSource("generateInput")
	@DisplayName("정규표현식 패턴 매칭 테스트")
	public void isRightPatternTest(String input, boolean expected) {
		assertThat(InputUtil.isRightPattern(input)).isEqualTo(expected);
	}

	static Stream<Arguments> generateInput() {
		return Stream.of(Arguments.of("1 + 2 / 3 + 4", true),
			Arguments.of("29+ 1 * 3 ", false),
			Arguments.of(" 19 +  2 + 39 + 4", false),
			Arguments.of("1 + 2 + 3 + 4 *", false),
			Arguments.of("19 * 2 / 39999 - 4", true),
			Arguments.of("1 + 2 + 39 + ^ 4 *", false),
			Arguments.of("1 + 2 . 3", false),
			Arguments.of("19 + 2 , 3", false),
			Arguments.of("99991 + 2 ( 3", false),
			Arguments.of("2", true),
			Arguments.of("2 - ", false),
			Arguments.of("2 / 0", false),
			Arguments.of("0 / 1", true),
			Arguments.of("5 * 0", true),
			Arguments.of("0 - 29", true));
	}
}