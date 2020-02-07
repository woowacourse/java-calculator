package calculator;

import calculator.expression.InvalidMathematicalExpressionException;
import calculator.expression.MathematicalExpression;
import input.CalculatorInputScanner;
import output.CalculatorPrinter;

public class Calculator {

    public void run() {
        CalculatorPrinter.printIntroduction();
        try {
            String userExpressionInput = CalculatorInputScanner.getExpression();
            MathematicalExpression expression = new MathematicalExpression(userExpressionInput);
            CalculatorPrinter.printExpression(expression);
        } catch (InvalidMathematicalExpressionException iee) {
            CalculatorPrinter.printException(iee);
        }
    }

}
