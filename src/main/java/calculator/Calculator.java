package calculator;

import domain.Numbers;
import domain.OperatorGroup;
import parser.InputParser;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class Calculator {
    private final static int FIRST_RESULT = 0;

    public static void run() {
        String input = InputView.inputCalculation();

        String[] expression = InputParser.split(input);
        Numbers numbers = new Numbers(InputParser.extractNumber(expression));
        ArrayList<OperatorGroup> operators = InputParser.extractOperator(expression);

        double result = calculate(numbers, operators);

        OutputView.printCalculate(result);
    }

    static double calculate(Numbers numbers, ArrayList<OperatorGroup> operators) {
        double result = Double.parseDouble(numbers.get(FIRST_RESULT));

        for (int operatorIndex = FIRST_RESULT, numberIndex = 1; operatorIndex < operators.size() ; operatorIndex++, numberIndex++) {
            OperatorGroup newOperator = operators.get(operatorIndex);
            Double newNumber = Double.parseDouble(numbers.get(numberIndex));
            result = newOperator.calculateBy(result, newNumber);
        }
        return result;
    }
}
