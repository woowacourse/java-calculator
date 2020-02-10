package view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import errors.InvalidInputException;

class InputViewTest {
    private Scanner scanner;
    private final ByteArrayOutputStream outView = new ByteArrayOutputStream();
    private InputView inputView;

    @Test
    @DisplayName("receiveInput() : return input from user")
    void receiveInput() throws InvalidInputException {
        String input = "2 + 3 / 4";
        System.setOut(new PrintStream(outView));
        inputView = createInputViewForTest(input);

        assertThat(inputView.receiveInput()).isEqualTo(input);
    }

    private InputView createInputViewForTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        scanner = new Scanner(System.in);

        return new InputView(scanner);
    }
}