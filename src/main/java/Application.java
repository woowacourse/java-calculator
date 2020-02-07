import domain.Calculator;
import domain.NumberSentence;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        NumberSentence numberSentence = inputView.getNumberSentence();

        Calculator calculator = new Calculator();
        int result = calculator.calculate(numberSentence);

        OutputView outputView = new OutputView();
        outputView.showCalculateResult(result);
    }
}
