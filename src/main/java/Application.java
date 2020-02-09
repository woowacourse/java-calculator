import calculator.*;

public class Application {
    private static Expression expression;

    public static void main(String[] args) {

        while (true) {
            InputView.askInput();
            String userInput = InputView.getUserInput();
            if (isCorrectExpression(userInput)) {
                break;
            }
        }

        double result = Calculator.calculate(expression);

        OutputView.printResult(result);
    }

    private static boolean isCorrectExpression(String userInput) {

        try {
            expression = new Expression(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
}
