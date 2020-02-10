package calculator;

import domain.Numbers;
import domain.OperatorGroup;
import parser.InputParser;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Calculator {
    private final static int ZERO = 0;
    private final static int ONE = 1;

    public static void run() {
        String input = InputView.inputCalculation();

        String[] expression = InputParser.split(input);
        Numbers numbers = new Numbers(InputParser.extractNumber(expression));
        List<OperatorGroup> operators = InputParser.extractOperator(expression);

        double result = calculate(numbers, operators);

        OutputView.printCalculate(result);
    }

    static double calculate(Numbers numbers, List<OperatorGroup> operators) {
        double result = Double.parseDouble(numbers.get(ZERO));
        int numberIndex = ONE;
        int operatorIndex = ZERO;

        while (operatorIndex < operators.size()) {
            OperatorGroup newOperator = operators.get(operatorIndex);
            Double newNumber = Double.parseDouble(numbers.get(numberIndex));
            result = newOperator.calculate(result, newNumber);
            numberIndex++;
            operatorIndex++;
        }
        return result;
    }
}
