package domain;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Queue;

public class Calculator {
    public int calculate(NumberSentence numberSentence) {
        Queue<String> operators = numberSentence.getOperators();
        List<Integer> numbers = numberSentence.getNumbers();
        int size = operators.size();
        int result = numbers.get(0);

        for (int i = 0; i < size; i++) {
            String operator = operators.poll();
            switch (operator) {
                case "+" :
                    result = add(result, numbers.get(i+1));
                    break;
                case "*":
                    result = multiply(result, numbers.get(i+1));
                    break;
                case "/":
                    result = divide(result, numbers.get(i+1));
                    break;
                case "-":
                    result = substract(result, numbers.get(i+1));
                    break;

                default:
                    throw new InvalidParameterException("not allowed ");
            }
        }
        return result;

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
