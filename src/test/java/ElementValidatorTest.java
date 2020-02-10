import calculator.ElementValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ElementValidatorTest {
    private ElementValidator elementValidator;

    @BeforeEach
    void setUp() {
        elementValidator = new ElementValidator();
    }

    @Test
    @DisplayName("숫자 위치에 숫자 이외의 문자가 입력됐을 때 True를 반환한다.")
    void checkNumberValueTest() {
        String[] wrongEquations = {"1","+","a"};

        Assertions.assertThatThrownBy(() -> {
            elementValidator.checkNumberValue(wrongEquations);
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string: \"a\"");
    }

    @Test
    @DisplayName("나누기 연산자 바로뒤에 0이 있으면 True를 반환하고 아니면 False를 반환한다.")
    void divideByZeroTest() {
        String[] wrongEquations = {"1","/","0"};
        String[] rightEquations = {"1","/","1"};
        assertThat(elementValidator.isDividedByZero(wrongEquations,1)).isEqualTo(true);
        assertThat(elementValidator.isDividedByZero(rightEquations,1)).isEqualTo(false);
    }

    @Test
    @DisplayName("식이 완성되지 않을 경우 True를 반환한다.")
    void invalidEquationTest() {
        String[] wrongEquations = {"1","/","2","+"};
        String[] rightEquations = {"1","/","5"};
        assertThat(elementValidator.isInvalidEquation(wrongEquations)).isEqualTo(true);
        assertThat(elementValidator.isInvalidEquation(rightEquations)).isEqualTo(false);
    }

    @Test
    @DisplayName("사칙연산 이외의 연산자가 입력됐을 때 True를 반환한다.")
    void wrongOperatorTest() {
        String[] wrongEquations = {"1","^","2"};
        String[] rightEquations = {"1","/","5"};
        assertThat(elementValidator.isWrongOperator(wrongEquations, 1)).isEqualTo(true);
        assertThat(elementValidator.isWrongOperator(rightEquations, 1)).isEqualTo(false);
    }

}
