package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Operands {
    private Queue<Double> operands;

    public Operands() {
        this.operands = new LinkedList<>();
    }

    public void add(double operand) {
        operands.offer(operand);
    }

    public Double remove() {
        return operands.poll();
    }
}
