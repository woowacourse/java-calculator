package calculator;

import expression.Expression;
import input.CalculatorInputScanner;

public class Calculator {

    public void run() {
        while (true) {
            String userExpressionInput = CalculatorInputScanner.getExpression();
            Expression expression = new Expression(userExpressionInput);
            Double userResult = expression.getResult();
            System.out.println("결과 : " + userResult);
        }
    }

}
