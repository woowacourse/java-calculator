package calculator;

import io.OutputView;
import io.UserInput;

public class CalculatorModel {
    private static final int STANDARD_NUMBER = 0;
    private static final UserInput userInput = new UserInput();

    public void run() throws IllegalAccessException {
        String[] userInputArray = userInput.getNumbersAndOperator();
        GameResult gameResult = new GameResult(userInputArray[STANDARD_NUMBER]);

        for (int i = 1; i < userInputArray.length; i += 2) {
            gameResult.resultCalculator(userInputArray[i], userInputArray[i + 1]);
        }

        OutputView.result(gameResult.getFinalResult());
    }
}
