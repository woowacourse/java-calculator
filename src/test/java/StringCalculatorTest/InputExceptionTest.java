package StringCalculatorTest;

import Controller.Operator;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class InputExceptionTest {

    private static String[] str = {"1","/","3","@"};

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

    @Test
    void validateOperators() {
        Operator result = Operator.getEnumFromString("@");
        assertThat(result).isNull();
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
