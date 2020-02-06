package StringCalculatorTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class InputExceptionTest {

    private static String[] str = {"+","3","3"};

    @Test
    void validateFirstAndLast()  {
        boolean result = !isInteger(str[0]) || !isInteger(str[str.length - 1]);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void validateRepeat(){
        boolean result;
        for (int i = 1; i < str.length; i++) {
            result = !(isInteger(str[i - 1]) ^ isInteger(str[i]));
            assertThat(result).isFalse();
        }
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
