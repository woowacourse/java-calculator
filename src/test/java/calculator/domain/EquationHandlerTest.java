package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EquationHandlerTest {
    @DisplayName("예외 케이스 테스트: 빈 문자열 혹은 공백이 입력된 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void handleEmptyEquation(String inputEquation) {
        assertThatThrownBy(() -> EquationHandler.handleRawEquation(inputEquation))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열");
    }

    @DisplayName("입력받은 수식으로 생성된 Equation 테스트")
    @Test
    void createEquation() {
        String inputEquation = " 1    + 2  * 3 / 4  ";
        assertThat(EquationHandler.handleRawEquation(inputEquation))
                .isEqualTo(new Equation(Arrays.asList("1", "+", "2", "*", "3", "/", "4")));
    }
}
