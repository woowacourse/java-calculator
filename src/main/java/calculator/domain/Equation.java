package calculator.domain;

import calculator.view.OutputView;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Equation {
    private Queue<String> equation;         // 수식 1+2*3/4에 대한 Equation 예시: ["1","+","2","*","3","/","4"]

    public Equation(List<String> equation) {
        this.equation = new LinkedList<>(equation);
    }

    public int calculate() {
        int result = pollNumber();
        while (isNotEmpty()) {
            Operators operator = pollOperator();
            result = operator.operate(result, pollNumber());
        }
        return result;
    }

    private boolean isNotEmpty() {
        return !equation.isEmpty();
    }

    private int pollNumber() {
        try {
            return Integer.parseInt(equation.poll());
        } catch (NumberFormatException e) {
            OutputView.printMessage_InvalidEquationCase();
            throw e;
        }
    }

    private Operators pollOperator() {
        return Operators.findOperator(equation.poll());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Equation) {
            Equation obj = (Equation) o;
            return Objects.equals(equation, obj.equation);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(equation);
    }
}
