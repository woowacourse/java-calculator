package calculator;

import io.OutputView;
import io.UserInput;

public class CalculatorModel {
    private static final UserInput userInput = new UserInput();

    public void runCalculator() {
        String[] numbersAndOperator = userInput.getNumbersAndOperator();
        GameResult gameResult = new GameResult(numbersAndOperator[0]);
        for (int i=1; i<numbersAndOperator.length; i+=2) {
            gameResult.resultCalculator(numbersAndOperator[i], numbersAndOperator[i+1]);
        }
        gameResult.getFinalResult();
    }
}
