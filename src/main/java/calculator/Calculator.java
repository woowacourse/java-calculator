package calculator;

import java.util.*;

public class Calculator {
    private Set opertors;
    private final static String plus = "+";
    private final static String minus = "-";
    private final static String multiply = "*";
    private final static String divide = "/";
    private final static String end = "q";

    public Calculator() {
        opertors = new HashSet<>();
        opertors.add("+");
        opertors.add("-");
        opertors.add("/");
        opertors.add("*");
    }

    public void start() {
        Integer result = null;
        while (true) {
            String inputEq = inputEquation();
            if (!validateString(inputEq)) {
                System.out.println("빈 문자열입니다. 다시 입력해주세요.");
                continue;
            }
            Queue<String> equation = makeQueue(inputEq);
            try {
                result = execute(equation);
            } catch (ArithmeticException e1) {
                System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
                continue;
            } catch (NumberFormatException e2) {
                System.out.println("잘못된 수식이 입력되었습니다.");
                continue;
            }
            if (result != null) {
                System.out.println(result);
                break;
            }
        }
    }

    private String inputEquation() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public boolean validateString(String inputEq) {
        return inputEq != null && !inputEq.equals("");
    }

    public Queue makeQueue(String inputString) {
        String[] elements = inputString.split("\\s+", 0);
        return new LinkedList<>(Arrays.asList(elements));
    }

    public int execute(Queue<String> equation) throws ArithmeticException, NumberFormatException {
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
