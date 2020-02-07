
import java.util.Scanner;

public class Calculator {
    String value;
    String[] values;
    double result = 0;

    public Calculator() {
        Scanner scanner = new Scanner(System.in);
        value = scanner.nextLine();
        values = value.split(" ");
        Validator.validateInput(values);
    }

    void calculate() {
        result = Double.parseDouble(values[0]);

        int length = values.length;
        Operator nowOperator = null;
        for (int i = 1; i < length; i++) {
            if (i % 2 == 1) { // 연산자일 때
                nowOperator = Operator.getOperatorByString(values[i]);
            }
            else { // 숫자가 나올 때
                result = nowOperator.operate(result, Double.parseDouble(values[i]));
            }
        }
    }

    void printResult() {
        System.out.print("결과: "+result);
    }
}
