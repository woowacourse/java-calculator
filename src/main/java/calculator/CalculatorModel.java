package calculator;

public class CalculatorModel {
    private static final UserInput userInput = new UserInput();
    private static final Operator operator = new Operator();

    public void runCalculator() {
        userInput.getNumbersAndOperator();
    }
}
