package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EquationTest {

    @DisplayName("예외 케이스 테스트: 숫자 순서에 문자가 들어간 경우(pollNumber() 테스트)")
    @Test
    void notNumber() {
        Equation wrongEquation = new Equation(Arrays.asList("/", "2", "+", "3"));
        assertThatThrownBy(() -> wrongEquation.calculate()).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("수식 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 / 3, 1", "9 - 8 * 9, 9", "6 / 2 + 3, 6"})
    void calculate(String inputEquation, int expectedResult) {
        assertThat(EquationHandler.handleRawEquation(inputEquation).calculate()).isEqualTo(expectedResult);
    }

    @DisplayName("(학습용)수식 계산 테스트 방법 2")
    @ParameterizedTest
    @MethodSource("provideEquations")
    void calculate2(Equation equation, int expectedResult) {
        assertThat(equation.calculate()).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideEquations() {
        return Stream.of(
                Arguments.of(new Equation(Arrays.asList("1", "+", "2", "/", "3")), 1),
                Arguments.of(EquationHandler.handleRawEquation("9 - 8 * 9"), 9),
                Arguments.of(EquationHandler.handleRawEquation("6 / 2 + 3"), 6)
        );
    }
}
