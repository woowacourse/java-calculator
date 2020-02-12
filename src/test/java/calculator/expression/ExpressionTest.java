package calculator.expression;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionTest {

    @ParameterizedTest
    @ValueSource(strings = {"3 + 2 * 6 / 2"})
    @DisplayName("정확한 식을 넣었을 때 객체가 생성되는지 확인하는 메서드")
    void testExpressionConstructor(String expressionString) {
        MathematicalExpression mathematicalExpression = new MathematicalExpression(expressionString);
    }

    @Test
    @DisplayName("잘못된 식: 연산자로 끝나는 식을 넣었을 때 예외 발생")
    void testValidate() {
        String expressionEndByOperator = "2 + 3 * 4 / 2 +";
        assertThatThrownBy(() -> new MathematicalExpression(expressionEndByOperator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 식: 연속되는 연산자가 들어있는 식을 넣었을 때 예외 발생")
    void testValidateWithContinuousOperator() {
        String continuousOperator = "2 + + 3 / 2";
        assertThatThrownBy(() -> new MathematicalExpression(continuousOperator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 식: 숫자가 연속되어 나타날 때 예외 발생")
    void testValidateWithContinuousNumber() {
        String continuousNumber = "2 + 3 4 + 5";
        assertThatThrownBy(() -> new MathematicalExpression(continuousNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 식: 숫자나 연산자가 아닌 문자가 포함된 식은 예외 발생")
    void testValidateWithAlphabet() {
        String expressionWithAlphabet = "2 + 3 * 4 / 2j";
        assertThatThrownBy(() -> new MathematicalExpression(expressionWithAlphabet))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 식: 단일한 연산자를 넣으면 예외 발생")
    void testAloneOperator() {
        String expressionString = "*";
        assertThatThrownBy(() -> new MathematicalExpression(expressionString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 식: 연산자 자리에 연산자가 아닌 다른 문자가 있으면 예외 발생")
    void testWrongCharacterInOperator() {
        String expressionString = "2 j 3";
        assertThatThrownBy(() -> new MathematicalExpression(expressionString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("식의 계산 결과를 확인")
    void testGetResult() {
        String expressionString = "2 + 3 * 4 / 2";
        MathematicalExpression mathematicalExpression = new MathematicalExpression(expressionString);
        assertThat(mathematicalExpression.getResult()).isEqualTo(10);
    }

    @Test
    @DisplayName("단일한 숫자를 넣으면 해당 숫자를 반환")
    void testAloneNumber() {
        String expressionString = "1";
        MathematicalExpression mathematicalExpression = new MathematicalExpression(expressionString);
        assertThat(mathematicalExpression.getResult()).isEqualTo(1);
    }

}