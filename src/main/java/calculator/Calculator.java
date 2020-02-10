package calculator;

import calculator.expression.MathematicalExpression;

public class Calculator {

    public MathematicalExpression createExpression(String inputFromUser) {
        return new MathematicalExpression(inputFromUser);
    }

}
