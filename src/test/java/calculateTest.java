import calculator.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class calculateTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }


    @Test
    @DisplayName("나누기 연산자 바로뒤에 0이 있으면 True를 반환하고 아니면 False를 반환한다.")
    void divideByZeroTest() {
        String[] wrongEquations = {"1","/","0"};
        String[] rightEquations = {"1","/","1"};
        assertThat(calculator.isDividedByZero(wrongEquations,1)).isEqualTo(true);
        assertThat(calculator.isDividedByZero(rightEquations,1)).isEqualTo(false);
    }

    @Test
    @DisplayName("식이 완성되지 않을 경우 True를 반환한다.")
    void invalidEquationTest() {
        String[] wrongEquations = {"1","/","2","+"};
        String[] rightEquations = {"1","/","5"};
        assertThat(calculator.isInvalidEquation(wrongEquations)).isEqualTo(true);
        assertThat(calculator.isInvalidEquation(rightEquations)).isEqualTo(false);
    }

    @Test
    @DisplayName("사칙연산 이외의 연산자가 입력됐을 때 True를 반환한다.")
    void wrongOperatorTest() {
        String[] wrongEquations = {"1","^","2"};
        String[] rightEquations = {"1","/","5"};
        assertThat(calculator.isWrongOperator(wrongEquations, 1)).isEqualTo(true);
        assertThat(calculator.isWrongOperator(rightEquations, 1)).isEqualTo(false);
    }

    @Test
    @DisplayName("숫자 위치에 숫자 이외의 문자가 입력됐을 때 True를 반환한다.")
    void checkNumberValueTest() {
        String[] wrongEquations = {"1","+","a"};

        Assertions.assertThatThrownBy(() -> {
            calculator.checkNumberValue(wrongEquations);
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string: \"a\"");
    }

    @Test
    @DisplayName("사칙연산자에 따라서 각 결과값이 맞게 나온다.")
    void distinguishOperatorTest() {
        String[] operators = {"+","-","*","/"};
        double prevNumber = 21.0;
        double nextNumber = 7;

        assertThat(calculator.distinguishOperator(prevNumber, operators[0],nextNumber)).isEqualTo(28.0);
        assertThat(calculator.distinguishOperator(prevNumber, operators[1],nextNumber)).isEqualTo(14.0);
        assertThat(calculator.distinguishOperator(prevNumber, operators[2],nextNumber)).isEqualTo(147.0);
        assertThat(calculator.distinguishOperator(prevNumber, operators[3],nextNumber)).isEqualTo(3.0);
    }

    @Test
    @DisplayName("식 배열을 입력했을 때 알맞게 사칙 연산된다.")
    void calculatorEquationTest() {
        String[] equations = {"1","+","2","*","3","/","3"};
        assertThat(calculator.calculateEquation(equations)).isEqualTo(3.0);
    }

}
