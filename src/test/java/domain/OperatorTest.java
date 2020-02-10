package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @ParameterizedTest
    @CsvSource(value = {"5,3"})
    @DisplayName("값 두개를 더하는 연산 테스트")
    void plusCalculationTest(double prev, double next) {
        assertThat(Operator.PLUS.calculate(prev, next)).isEqualTo(8);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,3"})
    @DisplayName("값 두개를 빼는 연산 테스트")
    void minusCalculationTest(double prev, double next) {
        assertThat(Operator.MINUS.calculate(prev, next)).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,3"})
    @DisplayName("값 두개를 곱하는 연산 테스트")
    void multiplyCalculationTest(double prev, double next) {
        assertThat(Operator.MULTIPLY.calculate(prev, next)).isEqualTo(15);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,10"})
    @DisplayName("값 두개를 나누는 연산 테스트")
    void divideCalculationTest(double prev, double next) {
        assertThat(Operator.DIVIDE.calculate(prev, next)).isEqualTo(0.5);
    }
}
