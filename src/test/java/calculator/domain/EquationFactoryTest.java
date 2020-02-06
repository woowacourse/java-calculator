package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

}