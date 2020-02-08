package view;

import domain.NumberSentence;
import view.errors.InvalidInputException;

import java.util.*;

public class InputView {
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public NumberSentence getNumberSentence() {
        String sentence = scanner.nextLine();

        if (!isAbleToParse(sentence)) {
            throw new InvalidInputException("not able to parse");
        }

        return buildNumberSentence(sentence);
    }

    private NumberSentence buildNumberSentence(String sentence) {
        List<Integer> numbers = new ArrayList<>();
        Queue<String> operators = new LinkedList<>();

        String[] arguments =  sentence.split(" ");
        List<String> arg = Arrays.asList(arguments);

        for (int i = 0; i < arguments.length; i++) {
            classify(i, arg, numbers, operators);
        }

        return new NumberSentence(numbers, operators);
    }

    private void classify(int index, List<String> arguments, List<Integer> numbers, Queue<String> operators) {
        if (index % 2 == 0) {
            numbers.add(Integer.parseInt(arguments.get(index)));
        }
        if (index % 2 != 0) {
            operators.add(arguments.get(index));
        }
    }

    //todo: 숫자 위치에 숫자가 아닌 입력이 있는 경우, 연산자 위치에 연산자가 아닌 경우 로직 추가
    private boolean isAbleToParse(String sentence) {
        if (sentence.isEmpty()) {
            return false;
        }
        for (int i = 0; i < sentence.length(); i++) {
            if (!validate(i, sentence.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private boolean validate(int index, char character) {
        if (index % 2 != 0 && character != ' ') {
            return false;
        }
        if (index % 4 == 0) {
            int num = Integer.parseInt(String.valueOf(character));
        }
        return (index % 4 == 0 || index % 2 != 0) || isOperator(character);
    }

    private boolean isOperator(char operator) {
        return operator == '+' || operator == '-' || operator == '*' || operator == '/';
    }
}
