package domain;


import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class NumberSentence {
    /* NumberSentence는 계산식을 의미합니다. */
    private final List<Integer> numbers;
    private final Queue<String> operators;

    public NumberSentence(List<Integer> numbers, Queue<String> operators) {
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
}
