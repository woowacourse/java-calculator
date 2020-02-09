package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperatorTest {
    @Test
    void PLUST_shouldCalculatePrecisely() {
        double result = Operator.calculate(3, Operator.PLUS, 2);
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    void MINUS_shouldCalculatePrecisely() {
        double result = Operator.calculate(5, Operator.MINUS, 3);
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    void MULTIPLY_shouldCalculatePrecisely() {
        double result = Operator.calculate(2, Operator.MULTIPLY, 4);
        Assertions.assertThat(result).isEqualTo(8);
    }

    @Test
    void DIVIDE_shouldCalculatePrecisely() {
        double result = Operator.calculate(5, Operator.DIVIDE, 2);
        Assertions.assertThat(result).isEqualTo(2.5);
    }
}