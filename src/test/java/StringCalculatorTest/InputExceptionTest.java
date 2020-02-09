package StringCalculatorTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class InputExceptionTest {

    private static String[] str = {"1","/","3","@"};

    @DisplayName("식의 처음과 끝이 숫자로 되어있는지 검사")
    @Test
    void validateFirstAndLast()  {
        boolean result = !isInteger(str[0]) || !isInteger(str[str.length - 1]);
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("숫자와 연산자가 번갈아 나오는지 검사")
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
