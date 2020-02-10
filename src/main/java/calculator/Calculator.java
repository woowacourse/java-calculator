package calculator;

import calculator.expression.MathematicalExpression;

public class Calculator {

    public MathematicalExpression run(String inputFromUser) {
        return new MathematicalExpression(inputFromUser);
    }

}
