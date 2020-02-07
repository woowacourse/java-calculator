package calculator;

import java.util.ArrayList;

public class Calculator {
    private final static int ZERO = 0;
    private final static int ONE = 1;

    public static void run() {
        // input

        // split

        // calculate
    }

    static double calculate(ArrayList<String> numbers, ArrayList<String> operators) {
        double result = Double.parseDouble(numbers.get(ZERO));
        int numberIndex = ONE;
        int operatorIndex = ZERO;
        while (operatorIndex < operators.size()) {
            String newOperator = operators.get(operatorIndex);
            Double newNumber = Double.parseDouble(numbers.get(numberIndex));
            result = doOperation(newOperator, result, newNumber);
            numberIndex++;
            operatorIndex++;
        }
        return result;
    }

    static double doOperation(String operator, double a, double b) {
        if (operator.equals("+")) {
            return a + b;
        }
        if (operator.equals("-")) {
            return a - b;
        }
        if (operator.equals("*")) {
            return a * b;
        }
        if (operator.equals("/")) {
            return a / b;
        }
        throw new IllegalStateException("잘못된 연산자가 입력되었습니다.");
    }

}
