package view;

import domain.NumberSentence;
import view.errors.InvalidInputException;

import java.util.*;

public class InputView {
    private Scanner scanner;

    InputView(Scanner scanner) {
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
        //"2 + 3 * 4 / 2";
        List<Integer> numbers = new ArrayList<>();
        Queue<String> operators = new LinkedList<>();

        String[] arguments =  sentence.split(" ");
        List<String> arg = Arrays.asList(arguments);

        for (int i = 0; i < arguments.length; i++) {
            if (i / 2 == 0) {
                numbers.add(Integer.parseInt(arg.get(i)));
            } else {
                operators.add(arg.get(i));
            }
        }

        return new NumberSentence(numbers, operators);
    }

    private boolean isAbleToParse(String sentence) {
        return true;
    }
}
