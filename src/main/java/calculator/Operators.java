package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Operators {
    private Queue<CalculatorType> operators;

    public Operators() {
        this.operators = new LinkedList<>();
    }

    public void add(CalculatorType operator) {
        operators.offer(operator);
    }

    public CalculatorType remove() {
        return operators.poll();
    }

    public boolean isEmpty() {
        return operators.isEmpty();
    }
}
