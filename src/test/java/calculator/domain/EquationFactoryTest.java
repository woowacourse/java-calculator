package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EquationFactoryTest {

    @DisplayName("입력받은 수식에서 식 분리하기")
    @Test
    void getNumbers() {
        //given
        List<String> input = Arrays.asList("1", "+", "3", "*", "5");
        //when
        Equation equation = EquationFactory.parseEquation(input);
        //then
        assertThat(equation).isEqualTo(new Equation(Arrays.asList(1D, 3D, 5D), Arrays.asList("+", "*")));
    }

    @DisplayName("입력받은 수식의 숫자갯수와 연산자 갯수가 올바르지 않은 경우")
    @Test
    void getNumbers2() {
        List<String> input = Arrays.asList("1", "+");

        assertThatThrownBy(() -> EquationFactory.parseEquation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("식이 올바르지 않습니다.\n숫자와 연산자의 개수를 확인해 주세요.");
    }
}