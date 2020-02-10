import java.util.Scanner;

public class InputValues {
    private static String value;
    private static String[] values;
    InputValidation inputValidation = new InputValidation();

    public InputValues() {
        System.out.print("문자열 수식을 입력해주세요: ");
        Scanner scanner = new Scanner(System.in);

        value = scanner.nextLine();
        values = value.split(" ");
        inputValidation.validateDouble(values);
        inputValidation.validateOperator(values);
        inputValidation.validateEndWithOperator(values);
    }

    public InputValues(String value){
        InputValues.value = value;
        values = value.split(" ");
    }

    public static String getValueByIndex(int index) {
        return values[index];
    }

    public static int getValuesLength() {
        return values.length;
    }
}
