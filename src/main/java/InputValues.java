import java.util.Scanner;

public class InputValues {
    private static String value;
    private static String[] values;

    public InputValues() {
        System.out.print("문자열 수식을 입력해주세요: ");
        Scanner scanner = new Scanner(System.in);

        value = scanner.nextLine();
        validateValue(value);
    }

    public InputValues(String value){
        this.value = value;
        validateValue(value);
    }

    void validateValue(String value) {
        values = value.split(" ");

        validateEndWithOperator();
        for (int i = 0; i < values.length; i++) {
            if (isNumberIndex(i))
                validateDouble(values[i]);
            if (isOperatorIndex(i))
                validateOperator(values[i]);
        }
    }

    void validateDouble(String value) {
        int length = values.length;

        for (int i = 0; i < length; i += 2) {
            try {
                Double.parseDouble(values[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("피연산자가 잘못되었습니다.");
            }
        }

    }

    void validateOperator(String value) {
        Operator.getOperatorByString(value);
    }

    void validateEndWithOperator() {
        int length = values.length;

        if (length % 2 == 0)
            throw new IllegalArgumentException("연산자와 숫자가 맞지 않습니다.");
    }

    public static String getValueByIndex(int index) {
    boolean isNumberIndex(int index) {
        if (index < 0)
            return false;
        if (index % 2 == 0)
            return true;
        return false;
    }

    boolean isOperatorIndex(int index) {
        if (index < 0)
            return false;
        if (index % 2 == 1)
            return true;
        return false;
    }

        return values[index];
    }

    public static int getValuesLength() {
        return values.length;
    }
}
