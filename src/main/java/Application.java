import calculator.Calculator;
import calculator.Expression;
import calculator.InputView;
import calculator.OutputView;

public class Application {

    public static void main(String[] args) {
        Expression expression = getInputExpression();
        double result = Calculator.calculate(expression);
        OutputView.printResult(result);
    }

    private static Expression getInputExpression() {
        Expression expression = null;

        while (expression == null) {
            InputView.askInput();
            String userInput = InputView.getUserInput();
            expression = createExpression(userInput);
        }

        return expression;
    }

    private static Expression createExpression(String userInput) {
        try {
            return new Expression(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
