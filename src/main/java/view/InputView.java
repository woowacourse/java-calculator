package view;

import domain.NumberSentence;
import java.util.*;

public class InputView {
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public NumberSentence getNumberSentence() {
        String sentence = scanner.nextLine();

        return NumberSentence.newInstance(sentence);
    }
}
