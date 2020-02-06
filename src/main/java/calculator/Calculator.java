package calculator;

import java.util.*;

public class Calculator {
    private Set opertors;
    private Queue<String> equation;
    private final static String plus = "+";
    private final static String minus = "-";
    private final static String multiply = "*";
    private final static String divide = "/";

    public Calculator() {
        opertors = new HashSet<>();
        opertors.add("+");
        opertors.add("-");
        opertors.add("/");
        opertors.add("*");
    }

    private String inputEquation(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public Queue makeQueue(String inputString) {
        String[] elements = inputString.split("\\s+", 0);
        return new LinkedList<>(Arrays.asList(elements));
    }

    public int execute() {
        int result = Integer.parseInt(equation.poll());
        while (!equation.isEmpty()) {
            String operator = equation.poll();
            int operand = Integer.parseInt(equation.poll());
            result = calculate(result, operator, operand);
        }
        return result;
    }

    public int calculate(int result, String operator, int operand) {
        switch (operator) {
            case plus:
                return add(result, operand);
            case minus :
                return subtract(result, operand);
            case multiply :
                return multiply(result, operand);
            case divide :
                return divide(result, operand);
            default :
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
        return a / b;
    }
}
