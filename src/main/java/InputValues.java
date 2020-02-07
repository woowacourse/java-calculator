import java.util.Scanner;

public class InputValues {
    private static String value;
    private static String[] values;

    public InputValues() {
        System.out.print("문자열 수식을 입력해주세요: ");
        Scanner scanner = new Scanner(System.in);

        value = scanner.nextLine();
        values = value.split(" ");
        validateDouble();
        validateOperator();
        validateEndWithOperator();
    }

    public InputValues(String value){
        this.value = value;
        values = value.split(" ");
    }

    void validateDouble() {
        int length = values.length;

        for (int i = 0; i < length; i += 2) {
            try {
                Double.parseDouble(values[i]);
            } catch (Exception e) {
                throw new IllegalArgumentException("피연산자가 잘못되었습니다.");
            }
        }

    }

    void validateOperator() {
        int length = values.length;

        for (int i = 1; i < length; i += 2) {
            Operator.getOperatorByString(values[i]);
        }
    }

    void validateEndWithOperator() {
        int length = values.length;

        if (length % 2 == 0)
            throw new IllegalArgumentException("연산자와 숫자가 맞지 않습니다.");
    }

    public static String getValueByIndex(int index) {
        return values[index];
    }

    public static int getValuesLength() {
        return values.length;
    }
}
