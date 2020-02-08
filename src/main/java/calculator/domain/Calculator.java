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
                String inputEq = InputView.inputEquation();
                Queue<String> equation = makeQueue(inputEq);
                int result = execute(equation);
                OutputView.printResult(result);
                break;
            } catch (ArithmeticException e) {
                OutputView.printMessage_DividedByZeroCase();
                continue;
            } catch (NumberFormatException | InputMismatchException e) {
                OutputView.printMessage_InvalidEquationCase();
                continue;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage_EmptyCase();
                continue;
            }
        }
    }

    private Queue<String> makeQueue(String inputString) {
        String[] elements = inputString.split("\\s+", 0);
        return new LinkedList<>(Arrays.asList(elements));
    }

    private int execute(Queue<String> equation) throws ArithmeticException, NumberFormatException, InputMismatchException {
        int result = validateNumber(equation.poll());
        while (!equation.isEmpty()) {
            Operators operator = Operators.findOperator(equation.poll());
            int operand = validateNumber(equation.poll());
            result = operator.operate(result, operand);
        }
        return result;
    }

    private int validateNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw e;
        }
    }
}
