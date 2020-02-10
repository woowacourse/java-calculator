package study;

import domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @ParameterizedTest
    @DisplayName("계산기 동작 확인")
    @CsvSource(value = {"1 + 3:4", "2 + 10:12", "4 - 8:-4", "6 * 2:12", "8 / 2:4"}, delimiter = ':')
    void CalculatorTest(String input, int expected) {
        assertThat(calculator.run(input)).isEqualTo(expected);
    }
}