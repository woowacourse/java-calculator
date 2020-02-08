package study;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.domain.Calculator;
import study.domain.Operator;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {"2 * 3,6", "4 / 2,2"})
    void calculate(String expression, double expected) {
        String[] values = expression.split(" ");
        double leftOperand = Double.parseDouble(values[0]);
        double rightOperand = Double.parseDouble(values[2]);
        assertThat(Operator.of(values[1]).calculate(leftOperand, rightOperand)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2,10", "2 + 4 / 2 * 6,18"})
    void calculateString(String expression, double expected) {
        Calculator calculator = new Calculator();
        String[] values = expression.split(" ");
        assertThat(calculator.calculateString(values)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 * 3 *", "3 3 3", "123*", "/ 5 * 3", "4 / 0", "2*5/4"})
    void calculateStringError(String expression) {
        Calculator calculator = new Calculator();
        String[] values = expression.split(" ");
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> {
                    calculator.calculateString(values);
                });
    }
}
