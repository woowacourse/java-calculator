package study;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    public static double calculate(String[] values) {
        Queue<String> elements = new LinkedList<>(Arrays.asList(values));
        double result = Double.parseDouble(elements.poll());
        while (!elements.isEmpty()) {
            String operator = elements.poll();
            double rightOperand = Double.parseDouble(elements.poll());
            result = Operator.of(operator)
                    .calculate(result, rightOperand);
        }
        return result;
    }
}
