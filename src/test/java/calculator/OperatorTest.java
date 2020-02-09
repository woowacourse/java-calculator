package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @DisplayName("연산기호가 아닌 입력값인 경우 true를 반환하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = { "^", "//", "+++", "a", "1"})
    void testIfInvalidInputThenReturnTrue(String input) {
        assertThat(Operator.isNotOperator(input)).isTrue();
    }

    @DisplayName("연산기호를 입력한 경우 false를 반환하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = { "+", "-", "*", "/" })
    void testIfValidInputThenReturnFalse(String input) {
        assertThat(Operator.isNotOperator(input)).isFalse();
    }

    @DisplayName("입력값이 연산기호면 Operator 인스턴스를 반환하는지 확인")
    @Test
    void testIfIsOperator() {
        assertThatInputEqualTo("+", Operator.PLUS);
        assertThatInputEqualTo("-", Operator.SUBTRACT);
        assertThatInputEqualTo("*", Operator.MULTIPLY);
        assertThatInputEqualTo("/", Operator.DIVIDE);
    }

    private void assertThatInputEqualTo(String input, Operator operator) {
        assertThat(Operator.getOperator(input)).isEqualTo(operator);
    }

    @DisplayName("입력값이 연산기호가 아니면 예외가 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = { "%", "&", ")", ">", "=" })
    void testIfIsNotOperator(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.getOperator(input));
    }
}