package calculator;

import domain.OperatorGroup;
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
        ArrayList<OperatorGroup> operators = InputParser.extractOperator(expression);

        double result = calculate(numbers, operators);

        OutputView.printCalculate(result);
    }

    static double calculate(ArrayList<String> numbers, ArrayList<OperatorGroup> operators) {
        double result = Double.parseDouble(numbers.get(ZERO));
        int numberIndex = ONE;
        int operatorIndex = ZERO;

        while (operatorIndex < operators.size()) {
            OperatorGroup newOperator = operators.get(operatorIndex);
            Double newNumber = Double.parseDouble(numbers.get(numberIndex));
            result = newOperator.calculateBy(result, newNumber);
            numberIndex++;
            operatorIndex++;
        }
        return result;
    }
}
