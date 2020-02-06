package calculator.domain;

import calculator.operator.OperatorGroup;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Equation {
    private final Queue<Double> numbers;
    private final Queue<String> operators;

    public Equation(List<Double> numbers, List<String> operators) {
        this.numbers = new LinkedList<>(numbers);
        this.operators = new LinkedList<>(operators);
    }

    public double getResult() {
        double result = numbers.poll();
        while (isNotEmpty()) {
            result = OperatorGroup.operate(result, operators.poll(), numbers.poll());
        }
        return result;
    }

    private boolean isNotEmpty() {
        return !numbers.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equation equation = (Equation) o;
        return Objects.equals(numbers, equation.numbers) &&
                Objects.equals(operators, equation.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, operators);
    }
}
