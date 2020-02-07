package calculator;

import parser.InputParser;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class Calculator {
    private final static int ZERO = 0;
    private final static int ONE = 1;

    public static void run() {
        String input = InputView.inputCalculation();

        String[] expression = InputParser.split(input);
        ArrayList<String> numbers = InputParser.extractNumber(expression);
        ArrayList<String> operators = InputParser.extractOperator(expression);

        double result = calculate(numbers, operators);

        OutputView.printCalculate(result);
    }

    static double calculate(ArrayList<String> numbers, ArrayList<String> operators) {
        double result = Double.parseDouble(numbers.get(ZERO));
        int numberIndex = ONE;
        int operatorIndex = ZERO;

        while (operatorIndex < operators.size()) {
            String newOperator = operators.get(operatorIndex);
            Double newNumber = Double.parseDouble(numbers.get(numberIndex));
            // result = doOperation(newOperator, result, newNumber);
            numberIndex++;
            operatorIndex++;
        }
        return result;
    }
}
