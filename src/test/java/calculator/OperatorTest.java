package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperatorTest {
    @Test
    public void isOperator() {
        final String CORRECT_CASE = "+";
        final String WRONG_CASE = "+ ";

        Assertions.assertThat(Operator.isOperator(CORRECT_CASE)).isEqualTo(true);
        Assertions.assertThat(Operator.isOperator(WRONG_CASE)).isEqualTo(false);
    }

    @Test
    public void operate() {
        Operator operator = new Operator("+");
        operator.operate(2, 3);
        Assertions.assertThat(operator.operate(2, 3)).isEqualTo(5);
    }
}
