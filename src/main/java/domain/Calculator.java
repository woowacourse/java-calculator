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
            Operation operation = Operator.getOperationByPattern(operators.poll());
            result = operation.operate(result, numbers.get(i + 1));
        }

        return result;

    }
}
