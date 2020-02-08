package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionTest {

    @Test
    @DisplayName("올바른 수식을 입력했을 때 Expression 클래스가 생성되는지 테스트")
    void testExpressionConstructor() {
        String expressionString = "2 + 3 * 4 / 2";
        Expression expression = new Expression(expressionString);
    }

    @Test
    @DisplayName("수식의 항이 짝수인지(연산자로 식이 종료되는지) 테스트")
    void testValidate() {
        String expressionEndByOperator = "2 + 3 * 4 / 2 +";
        assertThatThrownBy(() -> new Expression(expressionEndByOperator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수식에서 연산자가 연속으로 오는지 테스트")
    void testValidateWithContinuousOperator() {
        String continuousOperator = "2 + + 3 / 2";
        assertThatThrownBy(() -> new Expression(continuousOperator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수식에서 숫자가 연속으로 오는지 테스트")
    void testValidateWithContinuousNumber() {
        String continuousNumber = "2 + 3 4 + 5";
        assertThatThrownBy(() -> new Expression(continuousNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수식에서 숫자 자리에 다른 문자가 오는지 테스트")
    void testValidateWithAlphabet() {
        String expressionWithAlphabet = "2 + 3 * 4 / 2j";
        assertThatThrownBy(() -> new Expression(expressionWithAlphabet))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 수식의 결과 값을 제대로 출력하는지 테스트")
    void testGetResult() {
        String expressionString = "2 + 3 * 4 / 2";
        Expression expression = new Expression(expressionString);
        assertThat(expression.getResult()).isEqualTo(10);
    }

    @Test
    @DisplayName("입력받은 수식이 숫자 하나일 때 그 숫자를 출력하는지 테스트")
    void testAloneNumber() {
        String expressionString = "1";
        Expression expression = new Expression(expressionString);
        assertThat(expression.getResult()).isEqualTo(1);
    }

    @Test
    @DisplayName("입력받은 수식이 연산자 하나일 때 예외를 발생하는지 테스트")
    void testAloneOperator() {
        String expressionString = "*";
        assertThatThrownBy(() -> new Expression(expressionString))
                .isInstanceOf(IllegalArgumentException.class);
    }
}