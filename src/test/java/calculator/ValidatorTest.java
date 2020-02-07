package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ValidatorTest {
    private Validator validator;

    @BeforeEach
    public void setUp() {
        validator = new Validator();
    }

    private static Stream<String> InputStrings() {
        return Stream.of(" ", null, "", "1 + 2 + 3");
    }

    private static Stream<String> SplitedStrings() {
        return Stream.of("q + w + e", "1+2+3", "+ + 2", "1 abcd 2", "2 * 65 / 0", "1 + 2 + 3");
    }

    @ParameterizedTest
    @DisplayName("testing for valid string input")
    @MethodSource("InputStrings")
    public void isValidInputTest(String notValidInputString) {
        try {
            validator.isValidInput(notValidInputString);
            return;
        } catch (Exception e) {
            Assertions.assertThatThrownBy(() -> {
                validator.isValidInput(notValidInputString);
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Handled Exception");;
        }
    }

    @ParameterizedTest
    @DisplayName("testing for valid string input")
    @MethodSource("SplitedStrings")
    public void isValidSplitedInputTest(String notValidSplitedStrings) {
        String[] splitData = notValidSplitedStrings.split(" ");
        try {
            validator.isValidSplitedInput(splitData);
        } catch (Exception e) {
            Assertions.assertThatThrownBy(() -> {
                validator.isValidSplitedInput(splitData);
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Handled Exception");
        }
    }
}
