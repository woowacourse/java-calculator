import java.util.Scanner;

public class InputValues {
    private static final int ZERO = 0;

    private String value;
    private String[] values;

    public InputValues() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("문자열 수식을 입력해주세요: ");
        value = scanner.nextLine();
        values = value.split(" ");
        int valueLength = values.length;

        validateEndWithOperator(valueLength);
        for (int i = 0; i < valueLength; i++) {
            validateValues(i);
        }

    }

    public InputValues(String value) {
        this.value = value;
        values = value.split(" ");
    }

    void validateValues(int index) throws IllegalArgumentException{
        if (index % 2 == ZERO) {
            try {
                Double.parseDouble(values[index]);
            } catch (NumberFormatException ne) {
                throw new IllegalArgumentException("피연산자가 잘못되었습니다.");
            }
        } else{
            Operator.getOperatorByString(values[index]);
        }
    }

    void validateEndWithOperator(int valueLength) throws IllegalArgumentException{
        if (valueLength % 2 == ZERO) {
            throw new IllegalArgumentException("연산자와 숫자가 맞지 않습니다.");
        }
    }

    public String getValueByIndex(int index) {
        return values[index];
    }

    public int getValuesLength() {
        return values.length;
    }
}
