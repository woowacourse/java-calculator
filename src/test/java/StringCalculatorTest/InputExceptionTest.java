package StringCalculatorTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class InputExceptionTest {

    private static String[] str = {"+","1","+","3"};

    @Test
    void validateFirstAndLast()  {
        boolean result = !isInteger(str[0]) || !isInteger(str[str.length - 1]);
        assertThat(result).isEqualTo(true);
    }

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
