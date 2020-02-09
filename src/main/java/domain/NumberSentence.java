package domain;


import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class NumberSentence {
    /**
     *  NumberSentence는 계산식을 의미합니다.
     */
    private final List<Number> numbers;
    private final Queue<Operator> operators;

    public NumberSentence(List<Number> numbers, Queue<Operator> operators) {
        this.numbers = numbers;
        this.operators = operators;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberSentence that = (NumberSentence) o;
        return Objects.equals(numbers, that.numbers) &&
                Objects.equals(operators, that.operators);
    }

    Queue<Operator> getOperators() {
        return operators;
    }

    List<Number> getNumbers() {
        return numbers;
    }
}
