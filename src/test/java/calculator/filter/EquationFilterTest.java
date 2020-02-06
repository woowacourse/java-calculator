package calculator.filter;

import calculator.domain.Equation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EquationFilterTest {

    @DisplayName("입력받은 수식에서 식 분리하기")
    @Test
    void getNumbers() {
        //given
        List<String> input = Arrays.asList("1", "+", "3", "*", "5");
        //when
        Equation equation = EquationFilter.parseEquation(input);
        //then
        assertThat(equation).isEqualTo(new Equation(Arrays.asList(1D, 3D, 5D), Arrays.asList("+", "*")));
    }

}