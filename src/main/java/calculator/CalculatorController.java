package calculator;

import io.InputView;
import io.OutputView;

public class CalculatorController {
    private final InputView userInput = new InputView();
    private final TextCalculator textCalculator = new TextCalculator();

    public void runCalculator() {
        String input = userInput.requestInput();
        double result = textCalculator.run(input);
        OutputView.result(result);
    }
}
