package domain;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Queue;

public class Calculator {
    public int calculateNumberSentence(NumberSentence numberSentence) {
        Queue<String> operators = numberSentence.getOperators();
        List<Integer> numbers = numberSentence.getNumbers();
        int size = operators.size();
        int result = numbers.get(0);

        for (int i = 0; i < size; i++) {
            String operator = operators.poll();
            result = calculate(result, numbers.get(i+1), operator);
        }
        return result;
    }

    private int calculate(int first, int second, String operator) {
        if (operator.equals("+")) {
            return add(first, second);
        }
        if (operator.equals("-")) {
            return substract(first, second);
        }
        if (operator.equals("*")) {
            return multiply(first, second);
        }
        return divide(first, second);
    }

    private int add(int first, int second) {
        return first + second;
    }

    private int substract(int first, int second) {
        return first - second;
    }

    private int multiply(int first, int second) {
        return first * second;
    }

    private int divide(int first, int second) {
        return first / second;
    }
}
