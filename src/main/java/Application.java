import calculator.Calculator;
import view.ErrorView;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        while (true) {
            String input = InputView.inputExpression();
            useCalculator(input);
        }
    }

    public static void useCalculator(String input) {
        try {
            String result = Calculator.calculate(input);
            OutputView.printResult(result);
        } catch (IllegalArgumentException e) {
            ErrorView.println(e.getMessage());
        }
    }
}
