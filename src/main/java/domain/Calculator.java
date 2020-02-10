package domain;

import java.util.List;
import java.util.Queue;

public class Calculator {
    public Number calculateNumberSentence(NumberSentence numberSentence) {
        Queue<Operator> operators = numberSentence.getOperators();
        List<Number> numbers = numberSentence.getNumbers();
        int size = operators.size();
        Number result = numbers.get(Converter.FIRST_INDEX);

        for (int i = Converter.FIRST_INDEX; i < size; i++) {
            result = calculate(result, numbers.get(i + 1), operators.poll());
        }

        return result;
    }

    private Number calculate(Number first, Number second, Operator operator) {
        if (operator.isPlus()) {
            return first.add(second);
        } else if (operator.isMinus()) {
            return first.substract(second);
        } else if (operator.isMultiplification()) {
            return first.multiply(second);
        } else {
            return first.divide(second);
        }
    }
}
