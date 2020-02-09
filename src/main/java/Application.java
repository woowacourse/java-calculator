import domain.Calculator;
import domain.Converter;
import domain.NumberSentence;
import domain.Number;
import domain.errors.InvalidInputException;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        NumberSentence numberSentence = createNumberSentence();

        Calculator calculator = new Calculator();
        Number result = calculator.calculateNumberSentence(numberSentence);

        OutputView outputView = new OutputView();
        outputView.showCalculateResult(result);
    }

    private static NumberSentence createNumberSentence() {
        NumberSentence numberSentence = null;

        try {
            InputView inputView = new InputView(new Scanner(System.in));
            String sentence = inputView.receiveInput();

            Converter converter = new Converter();
            numberSentence = converter.getNumberSentence(sentence);
        } catch (NumberFormatException e) {
            System.out.println("There is something not number in number place");
            createNumberSentence();
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            createNumberSentence();
        }

        return numberSentence;
    }
}
