package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTest {
    private Calculator calculator;
    private Validator validator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        validator = new Validator();
    }

    static Stream<String> notValidInputStrings() {
        return Stream.of(" ", null, "");
    }

    static Stream<String> notValidSplitedStrings() {
        return Stream.of("q + w + e", "1+2+3", "+ + 2", "1 abcd 2", "2 * 65 / 0", "1 + 2 + 3");
    }

    @ParameterizedTest
    @MethodSource("notValidInputStrings")
    public void isValidInputTest(String notValidInputString) {
        Assertions.assertThatThrownBy(() -> {
            validator.isValidInput(notValidInputString);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Null or Blank or Empty exception.");
    }

    @ParameterizedTest
    @MethodSource("notValidSplitedStrings")
    public void isValidSplitedInputTest(String notValidSplitedStrings) {
        String[] splitData = notValidSplitedStrings.split(" ");
        Assertions.assertThatThrownBy(() -> {
            validator.isValidSplitedInput(splitData);
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
