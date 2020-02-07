package calculator.domain;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    private final static String plus = "+";
    private final static String minus = "-";
    private final static String multiply = "*";
    private final static String divide = "/";

    public Calculator() {
    }

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

    private Queue makeQueue(String inputString) {
        String[] elements = inputString.split("\\s+", 0);
        return new LinkedList<>(Arrays.asList(elements));
    }

    private int execute(Queue<String> equation) throws ArithmeticException, NumberFormatException, InputMismatchException {
        int result = validateNumber(equation.poll());
        while (!equation.isEmpty()) {
            String operator = equation.poll();
            int operand = validateNumber(equation.poll());
            result = calculate(result, operator, operand);
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

    private int calculate(int result, String operator, int operand) throws ArithmeticException {
        switch (operator) {
            case plus:
                return add(result, operand);
            case minus:
                return subtract(result, operand);
            case multiply:
                return multiply(result, operand);
            case divide:
                return divide(result, operand);
            default:
                throw new InputMismatchException("해당 연산자 없음");
        }
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            throw e;
        }
    }
}
