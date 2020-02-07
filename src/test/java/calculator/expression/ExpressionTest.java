package calculator.expression;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionTest {

    @Test
    void testExpressionConstructor() {
        String expressionString = "2 + 3 * 4 / 2";
        MathematicalExpression mathematicalExpression = new MathematicalExpression(expressionString);
    }

    @Test
    void testValidate() {
        String expressionEndByOperator = "2 + 3 * 4 / 2 +";
        assertThatThrownBy(() -> new MathematicalExpression(expressionEndByOperator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testValidateWithContinuousOperator() {
        String continuousOperator = "2 + + 3 / 2";
        assertThatThrownBy(() -> new MathematicalExpression(continuousOperator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testValidateWithContinuousNumber() {
        String continuousNumber = "2 + 3 4 + 5";
        assertThatThrownBy(() -> new MathematicalExpression(continuousNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testValidateWithAlphabet() {
        String expressionWithAlphabet = "2 + 3 * 4 / 2j";
        assertThatThrownBy(() -> new MathematicalExpression(expressionWithAlphabet))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testGetResult() {
        String expressionString = "2 + 3 * 4 / 2";
        MathematicalExpression mathematicalExpression = new MathematicalExpression(expressionString);
        assertThat(mathematicalExpression.getResult()).isEqualTo(10);
    }

    @Test
    void testAloneNumber() {
        String expressionString = "1";
        MathematicalExpression mathematicalExpression = new MathematicalExpression(expressionString);
        assertThat(mathematicalExpression.getResult()).isEqualTo(1);
    }

    @Test
    void testAloneOperator() {
        String expressionString = "*";
        assertThatThrownBy(() -> new MathematicalExpression(expressionString))
                .isInstanceOf(IllegalArgumentException.class);
    }
}