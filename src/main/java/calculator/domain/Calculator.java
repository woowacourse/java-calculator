package calculator.domain;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    public void start() {
        while (true) {
            try {
                Queue<String> equation = inputEquation(InputView.inputEquation());
                OutputView.printResult(calculate(equation));
                break;
            } catch (InputMismatchException | ArithmeticException | IllegalArgumentException e) {
                continue;
            }
        }
    }

    private Queue<String> inputEquation(String inputEquation) {
        String[] equationElements = inputEquation.split("\\s+", 0);
        return new LinkedList<>(Arrays.asList(equationElements));
    }

    private int calculate(Queue<String> equation) {
        int result = toNumber(equation.poll());
        while (!equation.isEmpty()) {
            Operators operator = Operators.findOperator(equation.poll());
            result = operator.operate(result, toNumber(equation.poll()));
        }
        return result;
    }

    private int toNumber(String element) {
        try {
            return Integer.parseInt(element);
        } catch (NumberFormatException e) {
            OutputView.printMessage_InvalidEquationCase();
            throw e;
        }
    }
}
