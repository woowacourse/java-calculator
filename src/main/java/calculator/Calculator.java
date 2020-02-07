package calculator;

import expression.Expression;
import input.CalculatorInputScanner;
import output.CalculatorPrinter;

public class Calculator {
    public void run() {
        CalculatorPrinter.printIntroduction();
        while (true) {
            String userExpressionInput = CalculatorInputScanner.getExpression();
            Expression expression = new Expression(userExpressionInput);
            CalculatorPrinter.print(expression);
        }
    }
}
