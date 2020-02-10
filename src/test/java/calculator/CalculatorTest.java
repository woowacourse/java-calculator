package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 * 3 - 4 / 5,1.0", "5 * 5 - 5 / 5,4.0"})
    void calculate_ShouldReturnOutputForValidInput(String input, String output) {
        Assertions.assertThat(Calculator.calculate(input)).isEqualTo(output);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1+1", "4 / 0 + 5"})
    void calculate_ShouldGenerateIllegalArgumentExceptionForInvalidInput(String input) {
        Assertions.assertThatThrownBy(() -> {
            Calculator.calculate(input);
        });
    }
}

