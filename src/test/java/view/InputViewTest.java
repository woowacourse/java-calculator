package view;

import domain.NumberSentence;
import domain.NumberSentenceTranslatorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private Scanner scanner;
    private final ByteArrayOutputStream outView = new ByteArrayOutputStream();
    private InputView inputView;
    @BeforeEach
    void init() {
        System.setOut(new PrintStream(outView));
    }

    @Test
    void getNumberSentenceWithProperInput() {
        String input = "2 + 3 * 4";
        inputView = createInputViewForTest(input);

        assertThat(inputView.getNumberSentence()).isEqualTo(new NumberSentence(Arrays.asList(2,3,4),new LinkedList<>(Arrays.asList("+", "*"))));


    }

    private InputView createInputViewForTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        scanner = new Scanner(System.in);

        return new InputView(scanner, new NumberSentenceTranslatorImpl());
    }
}