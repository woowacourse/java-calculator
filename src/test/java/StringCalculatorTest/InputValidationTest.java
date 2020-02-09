package StringCalculatorTest;

import Model.Operator;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class InputValidationTest {

    private static String[] str = {"3", "+", "4", "/","10","/","10"};

    @Test
    void validateFirstAndLast() {
        boolean result = !isInteger(str[0]) || !isInteger(str[str.length - 1]);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void validateRepeat() {
        boolean result;
        for (int i = 1; i < str.length; i++) {
            result = (isInteger(str[i - 1]) ^ isInteger(str[i]));
            assertThat(result).isTrue();
        }
    }

    @Test
    void validateOperators() {
        for (int i = 1; i < str.length; i += 2) {
            boolean result = Operator.PLUS.isOperator(str[i])
                    || Operator.MINUS.isOperator(str[i])
                    || Operator.MULTIPLY.isOperator(str[i])
                    || Operator.DIVIDE.isOperator(str[i]);
            assertThat(result).isTrue();
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
