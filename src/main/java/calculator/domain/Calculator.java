package calculator.domain;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    private static final String DELIMITER = "\\s+";
    private static final int ZERO = 0;

    public void start() {
        while (true) {
            try {
                Queue<String> equation = inputEquation();
                OutputView.printResult(calculate(equation));
                break;
            } catch (InputMismatchException | ArithmeticException | IllegalArgumentException e) {
                continue;
            }
        }
    }

    private Queue<String> inputEquation() {
        String rawEquation = validate(InputView.inputEquation());
        return handleRawEquation(rawEquation);
    }

    private static String validate(String rawEquation) {
        if (rawEquation.isEmpty()) {
            OutputView.printMessage_EmptyCase();
            throw new IllegalArgumentException("빈 문자열");
        }
        return rawEquation;
    }

    private Queue<String> handleRawEquation(String inputEquation) {
        String[] equationElements = inputEquation.split(DELIMITER, ZERO);
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
