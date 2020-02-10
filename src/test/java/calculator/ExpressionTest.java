package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExpressionTest {

    @DisplayName("사용자가 입력한 값이 입력 조건에 맞지 않는 경우 예외가 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"a + 3 / 8", "3 ^ 5 * 11", "3 / 3 *", "7-3+4", "   33 * 4   "})
    void testIfInvalidInputThenInvokeException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Expression(input);
        });
    }

    @DisplayName("사용자가 입력한 값이 입력 조건에 맞으면 Expression 인스턴스의 elements가 올바른지 확인")
    @Test
    void testIfValidInput() {
        Expression expression = new Expression("1 + 2 - 3 * 4");
        assertThat(expression.getReadOnlyElements())
                .containsExactly("1", "+", "2", "-", "3", "*", "4")
                .hasSize(7);
    }
}