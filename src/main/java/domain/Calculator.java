package domain;

import java.util.List;
import java.util.Queue;

public class Calculator {
    public Number calculateNumberSentence(NumberSentence numberSentence) {
        Queue<Operator> operators = numberSentence.getOperators();
        List<Number> numbers = numberSentence.getNumbers();
        int size = operators.size();
        Number result = numbers.get(Converter.FIRST_INDEX);

        for (int i = 0; i < size; i++) {
            result = calculate(result, numbers.get(i + 1), operators.poll());
        }
        return result;
    }

    private Number calculate(Number first, Number second, Operator operator) {
        if (operator == Operator.PLUS) {
            return first.add(second);
        } else if (operator == Operator.MINUS) {
            return first.substract(second);
        } else if (operator == Operator.MULTIPLIFICATION) {
            return first.multiply(second);
        } else {
            return first.divide(second);
        }
    }
}
