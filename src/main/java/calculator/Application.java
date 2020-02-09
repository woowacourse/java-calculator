package calculator;

import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String userInput = null;
        boolean isContinue = true;

        while (isContinue) {
            operateOnce(calculator, userInput);
            OutputView.printAnswer(calculator.getResult());
            isContinue = InputView.enterYesNo();
        }
    }

    private static void operateOnce(Calculator calculator, String userInput) {
        try {
            userInput = InputView.enterMathematicalExpression();
            CalculatorException.checkValidInput(userInput);
            calculator.calculate(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            operateOnce(calculator, userInput);
        }
    }
}
