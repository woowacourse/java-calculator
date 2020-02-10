import calculator.Calculator;
import domain.Numbers;
import domain.OperatorGroup;
import parser.InputParser;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CalculatorApplication {
    public static void main(String[] args) {

        String input = InputView.inputCalculation();

        String[] expression = InputParser.split(input);
        Numbers numbers = new Numbers(InputParser.extractNumber(expression));
        List<OperatorGroup> operators = InputParser.extractOperator(expression);

        double result = Calculator.calculate(numbers, operators);

        OutputView.printCalculate(result);
    }
}
