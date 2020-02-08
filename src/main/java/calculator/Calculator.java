package calculator;

import domain.Expression;

import static io.Input.inputExpression;
import static io.Output.printResult;

public class Calculator {
    public void run() {
        String userExpression = inputExpression();

        Expression expression = new Expression(userExpression);
        Double userResult = expression.getResult();

        printResult(userResult);
    }
}
