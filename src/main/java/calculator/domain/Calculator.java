package calculator.domain;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.*;

public class Calculator {
    private final static String plus = "+";
    private final static String minus = "-";
    private final static String multiply = "*";
    private final static String divide = "/";
    private final static String end = "q";

    public Calculator() {
    }

    public void start() {
        Integer result = null;
        while (true) {
            String inputEq = "";
            try {
                inputEq = InputView.inputEquation();
            } catch (IllegalArgumentException e) {
                OutputView.printMessage_EmptyCase();
                continue;
            }
            Queue<String> equation = makeQueue(inputEq);
            try {
                result = execute(equation);
            } catch (ArithmeticException e) {
                OutputView.printMessage_DividedByZeroCase();
                continue;
            } catch (NumberFormatException | InputMismatchException e) {
                OutputView.printMessage_InvalidEquationCase();
                continue;
            }
            if (result != null) {
                OutputView.printResult(result);
                break;
            }
        }
    }

    public Queue makeQueue(String inputString) {
        String[] elements = inputString.split("\\s+", 0);
        return new LinkedList<>(Arrays.asList(elements));
    }

    public int execute(Queue<String> equation) throws ArithmeticException, NumberFormatException, InputMismatchException {
        int result = validateNumber(equation.poll());
        while (!equation.isEmpty()) {
            String operator = equation.poll();
            int operand = validateNumber(equation.poll());
            result = calculate(result, operator, operand);
        }
        return result;
    }

    public int validateNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public int calculate(int result, String operator, int operand) throws ArithmeticException {
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

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            throw e;
        }
    }
}
