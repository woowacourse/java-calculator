package calculator.filter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EquationFilterTest {

    @DisplayName("입력받은 수식에서 숫자만 골라내기")
    @Test
    void getNumbers() {
        //given
        List<String> equation = Arrays.asList("1", "+", "3", "*", "5");
        //when
        List<String> numbers = EquationFilter.getNumbers(equation);
        //then
        assertThat(numbers).containsExactly("1", "3", "5");
    }

    @DisplayName("입력받은 수식에서 연산자만 골라내기")
    @Test
    void getOperations() {
        //given
        List<String> equation = Arrays.asList("1", "+", "3", "*", "5");
        //when
        List<String> operations = EquationFilter.getOperations(equation);
        //then
        assertThat(operations).containsExactly("+", "*");
    }
}