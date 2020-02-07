package expression;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionTest {

    @Test
    void testExpressionConstructor() {
        String expressionString = "2 + 3 * 4 / 2";
        Expression expression = new Expression(expressionString);
    }

    @Test
    void testValidate() {
        String expressionEndByOperator = "2 + 3 * 4 / 2 +";
        assertThatThrownBy(() -> new Expression(expressionEndByOperator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testValidateWithContinuousOperator() {
        String continuousOperator = "2 + + 3 / 2";
        assertThatThrownBy(() -> new Expression(continuousOperator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testValidateWithContinuousNumber() {
        String continuousNumber = "2 + 3 4 + 5";
        assertThatThrownBy(() -> new Expression(continuousNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }


}