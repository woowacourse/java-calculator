import java.util.Scanner;
class Input{
    String value;
    String[] values;

    public Input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열 수식을 입력해주세요 : ");
        value = scanner.nextLine();
        values = value.split(" ");
    }

    public Input(String input){
        this.value = input;
        this.values = value.split(" ");
    }

    public int getValuesLength(){
        return values.length;
    }

    public String getValueByIndex(int index){
        return values[index];
    }
}
public class InputValues {
    private static final int ZERO = 0;

    Input input;

    public InputValues(Input input) throws IllegalArgumentException {
        this.input = input;
        int valueLength = input.getValuesLength();

        validateEndWithOperator(valueLength);
        for (int i = 0; i < valueLength; i++) {
            validateValues(i);
        }

    }

    public InputValues(String value) {
        Input input = new Input(value);
    }

    void validateValues(int index) throws IllegalArgumentException{
        if (index % 2 == ZERO) {
            try {
                Double.parseDouble(input.getValueByIndex(index));
            } catch (NumberFormatException ne) {
                throw new IllegalArgumentException("피연산자가 잘못되었습니다.");
            }
        } else{
            Operator.getOperatorByString(input.getValueByIndex(index));
        }
    }

    void validateEndWithOperator(int valueLength) throws IllegalArgumentException{
        if (valueLength % 2 == ZERO) {
            throw new IllegalArgumentException("연산자와 숫자가 맞지 않습니다.");
        }
    }

    Input getInput(){
        return input;
    }
}
