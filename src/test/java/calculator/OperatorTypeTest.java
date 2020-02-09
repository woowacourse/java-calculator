package calculator;

import com.woowacourse.calculator.domain.OperatorType;
import com.woowacourse.calculator.exception.InfinityException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 클래스 이름 : OperatorTypeTest.java
 *
 * @author S.W.PARK
 * @author K.S.KIM
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/06
 */
public class OperatorTypeTest {
    @ParameterizedTest
    @DisplayName("of 테스트")
    @CsvSource(value = {"+", "-", "/", "*"})
    void of(String value) {
        Assertions.assertThat(OperatorType.of(value))
                .isInstanceOf(OperatorType.class);
    }

    @ParameterizedTest
    @DisplayName("미리 정의된 연산자에 해당하지 않는 문자열 인자를 받은 경우")
    @ValueSource(strings = {"1", "\\", "s", " ", ""})
    void of_Should_ThrowIllegalArgumentException_When_UnexpectedString(String value) {
        Assertions.assertThatThrownBy(() -> OperatorType.of(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산자에 포함되지 않습니다.");
    }

    @Test
    @DisplayName("plus 연산 테스트")
    void calculate_Plus() {
        OperatorType plus = OperatorType.PLUS;
        Assertions.assertThat(plus.calculate(3D, 3D))
                .isEqualTo(6D);
    }

    @Test
    @DisplayName("minus 연산 테스트")
    void calculate_Minus() {
        OperatorType minus = OperatorType.MINUS;
        Assertions.assertThat(minus.calculate(3D, 3D))
                .isEqualTo(0D);
    }

    @Test
    @DisplayName("divide 연산 테스트")
    void calculate_Divide() {
        OperatorType divide = OperatorType.DIVIDE;
        Assertions.assertThat(divide.calculate(3D, 3D))
                .isEqualTo(1D);
    }

    @Test
    @DisplayName("multiply 연산 테스트")
    void calculate_Multiply() {
        OperatorType multiply = OperatorType.MULTIPLY;
        Assertions.assertThat(multiply.calculate(3D, 3D))
                .isEqualTo(9D);
    }

    @Test
    @DisplayName("0으로 나누는 시도를 하는 경우")
    void calculate_Divide_Should_ArithmeticException_When_DivideByZero() {
        Assertions.assertThatThrownBy(() -> {
            OperatorType divide = OperatorType.DIVIDE;
            divide.calculate(3D, 0D);
        }).isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("0으로 나눌 수 없습니다");
    }

    @Test
    @DisplayName("연산 오버플로우 테스트")
    void calculate_Should_PositiveInfinity_When_ExceedDoubleRange() {
        OperatorType plus = OperatorType.PLUS;
        Assertions.assertThatThrownBy(() -> plus.calculate(Double.MAX_VALUE, Double.MAX_VALUE))
                .isInstanceOf(InfinityException.class);
    }

    @Test
    @DisplayName("연산 언더플로우 테스트")
    void calculate_Should_NegativeInfinity_When_ExceedDoubleRange() {
        OperatorType minus = OperatorType.MINUS;
        Assertions.assertThatThrownBy(() -> minus.calculate(-Double.MAX_VALUE, Double.MAX_VALUE))
                .isInstanceOf(InfinityException.class);
    }
}
