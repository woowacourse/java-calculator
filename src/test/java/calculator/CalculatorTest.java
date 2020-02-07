package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @DisplayName("calculate testing for each operator")
    @CsvSource(value = {"1 + 2 3", "1 - 2 -1", "1 * 2 2", "1 / 2 0.5"}, delimiter = ' ')
    public void calculateByOperatorTest(double left, String operator, double right, double result) {
        Assertions.assertThat(result).isEqualTo(calculator.calculateByOperator(left, right, operator));
    }

    @Test
    @DisplayName("calculate testing for split string input")
    public void calculateTest() {
        String[] splitInput = {"1", "+", "2", "-", "4", "*", "5", "/", "2"};
        double result = -2.5;
        Assertions.assertThat(result).isEqualTo(calculator.calculate(splitInput));
    }
}
