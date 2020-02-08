package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
    private Calculator calculator;
    private ValidityInspector validityInspector;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        validityInspector = new ValidityInspector();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    public void checkUserInputIsBlankOrEmptyTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            validityInspector.checkUserInputIsBlankOrEmpty(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백 또는 빈 문자열을 입력하셨습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"        ", "q + w + e", "1+2+3", "+ + 2", "1 abcd 2", "2 * 65 / 0"})
    public void checkCanConvertUserInputToNumberAndOperatorTest(String input) {
        String[] splitData = input.split(Constant.BLANK);
        Assertions.assertThatThrownBy(() -> {
            validityInspector.checkCanConvertUserInputToNumberAndOperator(splitData);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void addTest() {
        String[] numericalExpression = {"1", "+", "2"};
        Double result = calculator.calculate(numericalExpression);
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    public void subtractTest() {
        String[] numericalExpression = {"1", "-", "2"};
        Double result = calculator.calculate(numericalExpression);
        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    public void multipleTest() {
        String[] numericalExpression = {"1", "*", "2"};
        Double result = calculator.calculate(numericalExpression);
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    public void divideTest() {
        String[] numericalExpression = {"1", "/", "2"};
        Double result = calculator.calculate(numericalExpression);
        Assertions.assertThat(result).isEqualTo(0.5d);
    }
}
