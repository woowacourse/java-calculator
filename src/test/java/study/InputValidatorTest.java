package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.InputValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @DisplayName("Validator 동작 확인")
    @CsvSource(value = {"1 + /f", "2+ 10 / 0", "4 - - 8", "6 * 12 +", "8 / 2+", "0/0", "0 / 0"})
    void CalculatorTest(String input) {
        assertThatThrownBy(() -> {
            inputValidator.checkInputHandler(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}