package calculator;

import domain.Expression;
import io.ConsoleInput;
import io.ConsoleOutput;

public class Calculator {
    public void run(ConsoleInput input, ConsoleOutput output) {
        output.printStartMessage();
        String userExpression = input.inputExpression();

        Expression expression = new Expression(userExpression);
        Double userResult = expression.getResult();

        output.printResult(userResult);
        output.printEndMessage();
    }
}
