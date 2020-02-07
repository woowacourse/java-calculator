package calculator;

import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        boolean isContinue = true;

        while (isContinue) {
            calculator.enterMathematicalExpression();
            OutputView.printAnswer(calculator.calculate());
            isContinue = InputView.enterYesNo();
        }
    }
}
