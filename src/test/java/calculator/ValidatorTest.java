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
        return Stream.of(" ", null, "", "q + w + e", "1+2+3", "+ + 2", "1 abcd 2", "2 * 65 / 0", "1 + 2 + 3");
    }

    @ParameterizedTest
    @DisplayName("testing for valid string input")
    @MethodSource("InputStrings")
    public void isValidInputTest(String inputString) {
        Assertions.assertThat(validator.isValidInput(inputString)).isTrue();
    }
}
