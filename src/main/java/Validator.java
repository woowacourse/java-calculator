import java.util.Scanner;

public class Validator {
    public static void validateInput(String[] values) {
        int length = values.length;

        if (length % 2 == 0)
            throw new IllegalArgumentException("연산자와 숫자가 맞지 않습니다.");

        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                validateDouble(values[i]);
            }
            else {
                validateOperator(values[i]);
            }
        }
    }

    static void validateDouble(String input) {
        try {
            Double.parseDouble(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("피연산자가 잘못되었습니다.");
        }
    }

    static void validateOperator(String input) {
        Operator.getOperatorByString(input);
    }
}
