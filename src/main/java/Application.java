import calculator.Calculator;
import calculator.expression.MathematicalExpression;
import input.InputScanner;
import output.OutputPrinter;

public class Application {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        OutputPrinter.printIntroduction();
        String expressionInputFromUser = InputScanner.getExpression();
        MathematicalExpression expression = calculator.createExpression(expressionInputFromUser);
        OutputPrinter.printExpression(expression);
    }
}
