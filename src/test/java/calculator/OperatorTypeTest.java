package calculator;

import com.woowacourse.calculator.domain.OperatorType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
    @DisplayName("normal case test")
    @ValueSource(strings = {"+", "-", "/", "*"})
    void testOf(String value) {
        Assertions.assertThat(OperatorType.of(value))
                .isInstanceOf(OperatorType.class);
    }

    @ParameterizedTest
    @DisplayName("unexpected case test")
    @ValueSource(strings = {"1", "**", "x", "\\", "s"})
    void Should_ThrowException_When_WrongString(String value) {
        Assertions.assertThatThrownBy(() -> {
            OperatorType.of(value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산자에 포함되지 않습니다.");
    }

    @Test
    @DisplayName("noramal plus calculate case")
    void testPlusCalculate() {
        Double firstOperand = 3d;
        Double secondOperand = 3d;
        Double result = 6d;
        OperatorType plus = OperatorType.PLUS;

        Assertions.assertThat(plus.calculate(firstOperand, secondOperand))
                .isEqualTo(result);
    }

    @Test
    @DisplayName("noramal minus calculate case")
    void testMinusCalculate() {
        Double firstOperand = 3d;
        Double secondOperand = 3d;
        Double result = (double) 0;
        OperatorType minus = OperatorType.MINUS;

        Assertions.assertThat(minus.calculate(firstOperand, secondOperand))
                .isEqualTo(result);
    }

    @Test
    @DisplayName("noramal divide calculate case")
    void testDivideCalculate() {
        Double firstOperand = 3d;
        Double secondOperand = 3d;
        Double result = 1d;
        OperatorType divide = OperatorType.DIVIDE;

        Assertions.assertThat(divide.calculate(firstOperand, secondOperand))
                .isEqualTo(result);
    }

    @Test
    @DisplayName("noramal multiply calculate case")
    void testMultiplyCalculate() {
        Double firstOperand = 3d;
        Double secondOperand = 3d;
        Double result = 9d;
        OperatorType multiply = OperatorType.MULTIPLY;

        Assertions.assertThat(multiply.calculate(firstOperand, secondOperand))
                .isEqualTo(result);
    }

}
