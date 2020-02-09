package calculator;

import calculator.view.InputView;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class CalculatorTest {

    @Test
    void run() {
        //given
        InputStream input = new ByteArrayInputStream("1 + 2".getBytes());
        Scanner scanner = new Scanner(input);
        InputView inputView = new InputView(scanner);
        Calculator c = new Calculator(inputView);
    }
}