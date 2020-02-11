import calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("식이 입력됐을 때 식을 연산자와 피연산자로 나누어 연산자의 갯수를 반환한다.")
    void divideEquationIntoOperandsOperatorTest() {
        String[] equation = {"1", "+", "2", "*", "3"};
        assertThat(calculator.divideEquationIntoOperandsOperator(equation)).isEqualTo(2);
    }

    @Test
    @DisplayName("식을 인자로 입력했을 때 알맞게 사칙 연산된다.")
    void calculateEquationTest() {
        assertThat(calculator.calculateEquation(1, "+", 7)).isEqualTo(8.0);
    }

}
