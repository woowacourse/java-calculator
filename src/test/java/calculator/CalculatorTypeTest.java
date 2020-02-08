package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTypeTest {
    @Test
    void PLUST_shouldCalculatePrecisely() {
        double result = CalculatorType.calculate(3, CalculatorType.PLUS, 2);
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    void MINUS_shouldCalculatePrecisely() {
        double result = CalculatorType.calculate(5, CalculatorType.MINUS, 3);
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    void MULTIPLY_shouldCalculatePrecisely() {
        double result = CalculatorType.calculate(2, CalculatorType.MULTIPLY, 4);
        Assertions.assertThat(result).isEqualTo(8);
    }

    @Test
    void DIVIDE_shouldCalculatePrecisely() {
        double result = CalculatorType.calculate(5, CalculatorType.DIVIDE, 2);
        Assertions.assertThat(result).isEqualTo(2.5);
    }
}