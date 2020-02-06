package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void calculate() {
        Expression expression = new Expression("1 + 3 * 5 - 2");
        Assertions.assertThat(Calculator.calculate(expression)).isEqualTo(18);
    }
}
