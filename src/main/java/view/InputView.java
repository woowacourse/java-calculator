package view;

import domain.NumberSentence;
import domain.NumberSentenceTranslator;
import view.errors.InvalidInputException;

import java.util.*;

public class InputView {
    private Scanner scanner;
    private NumberSentenceTranslator numberSentenceTranslator;

    public InputView(Scanner scanner, NumberSentenceTranslator numberSentenceTranslator) {
        this.scanner = scanner;
        this.numberSentenceTranslator = numberSentenceTranslator;
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
            if (i % 2 == 0) {
                numbers.add(Integer.parseInt(arg.get(i)));
            } else {
                operators.add(arg.get(i));
            }
        }

        return this.numberSentenceTranslator.traslate(numbers, operators);
    }

    //todo: 숫자 위치에 숫자가 아닌 입력이 있는 경우, 연산자 위치에 연산자가 아닌 경우 로직 추가
    private boolean isAbleToParse(String sentence) {
        return !sentence.isEmpty();
    }
}
