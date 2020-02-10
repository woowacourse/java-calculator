package calculator;

import calculator.expression.InvalidMathematicalExpressionException;
import calculator.expression.MathematicalExpression;
import input.InputScanner;
import output.OutputPrinter;

public class Calculator {

    public void run(InputScanner inputScanner, OutputPrinter outputPrinter) {
        try {
            String userExpressionInput = inputScanner.getExpression();
            MathematicalExpression expression = new MathematicalExpression(userExpressionInput);
            outputPrinter.printExpression(expression);
        } catch (InvalidMathematicalExpressionException ime) {
            outputPrinter.printException(ime);
        }
    }

}
