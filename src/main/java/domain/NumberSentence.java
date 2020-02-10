package domain;


import view.errors.InvalidInputException;

import java.util.*;

public class NumberSentence {
    /* NumberSentence는 계산식을 의미합니다. */
    private final List<Integer> numbers;
    private final Queue<String> operators;

    public NumberSentence(List<Integer> numbers, Queue<String> operators) {
        this.numbers = numbers;
        this.operators = operators;
    }

    public static NumberSentence newInstance(String sentence) {
        if (!isAbleToParse(sentence)) {
            throw new InvalidInputException("not able to parse");
        }

        return buildNumberSentence(sentence);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberSentence that = (NumberSentence) o;
        return Objects.equals(numbers, that.numbers) &&
                Objects.equals(operators, that.operators);
    }

    Queue<String> getOperators() {
        return operators;
    }

    List<Integer> getNumbers() {
        return numbers;
    }

    private static NumberSentence buildNumberSentence(String sentence) {
        List<Integer> numbers = new ArrayList<>();
        Queue<String> operators = new LinkedList<>();

        String[] arguments =  sentence.split(" ");
        List<String> arg = Arrays.asList(arguments);

        for (int i = 0; i < arguments.length; i++) {
            if (i % 2 == 0) {
                numbers.add(Integer.parseInt(arg.get(i)));
            } else {
                operators.add(arg.get(i));
            }
        }

        return new NumberSentence(numbers, operators);
    }

    //todo: 숫자 위치에 숫자가 아닌 입력이 있는 경우, 연산자 위치에 연산자가 아닌 경우 로직 추가
    private static boolean isAbleToParse(String sentence) {
        return !sentence.isEmpty();
    }
}
