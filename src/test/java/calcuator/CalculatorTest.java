package calcuator;

import calculator.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 * 3 - 4 / 5:1.0", ":e", "1+1:e"}, delimiter = ':')
    void calculate_ShouldCalculateOrException(String input, String output) {
        if (output.equals("e")) {
            Assertions.assertThatThrownBy(() -> {
                Calculator.calculate(input);
            });
            return;
        }

        Assertions.assertThat(Calculator.calculate(input)).isEqualTo(output);
    }
}

