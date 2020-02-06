package calculator;

import domain.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @DisplayName("덧셈 테스트")
    @Test
    void addition() {
        Assertions.assertThat(calculator.addition(4,5)).isEqualTo(9);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    void subtraction() {
        Assertions.assertThat(calculator.subtraction(4,5)).isEqualTo(-1);
    }

    @DisplayName("곱셈 테스트")
    @Test
    void multiplication() {
        Assertions.assertThat(calculator.multiplication(4,5)).isEqualTo(20);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void division() {
        Assertions.assertThat(calculator.division(20,5)).isEqualTo(4);
    }
}
