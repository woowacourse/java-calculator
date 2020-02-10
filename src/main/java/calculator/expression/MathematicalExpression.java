package calculator.expression;

import calculator.operaotr.Operator;
import calculator.operaotr.OperatorException;

import java.util.ArrayList;
import java.util.List;

public class MathematicalExpression {

    private static final String NUMBER_OPERATOR_DELIMITER = " ";

    private List<Double> numbers = new ArrayList<>();
    private List<Operator> operators = new ArrayList<>();

    public MathematicalExpression(String expression) {
        String[] tokens = expression.split(NUMBER_OPERATOR_DELIMITER);

        validate(tokens);

        for (int i = 0; i < tokens.length; i++) {
            parseComponent(i, tokens[i]);
        }
    }

    private void validate(String[] tokens) {
        if (tokens.length % 2 == 0) {
            throw new InvalidMathematicalExpressionException(InvalidMathematicalExpressionException.WRONG_MATCH_NUMBER_OPERATOR);
        }
    }

    private void parseComponent(int i, String token) {
        if (isNumberIndex(i)) {
            numbers.add(tokenToDouble(token));
        }
        if (isOperatorIndex(i)) {
            operators.add(tokenToOperator(token));
        }
    }

    private boolean isNumberIndex(int i) {
        return i % 2 == 0;
    }

    private boolean isOperatorIndex(int i) {
        return i % 2 == 1;
    }

    private Double tokenToDouble(String token) {
        try {
            return Double.parseDouble(token);
        } catch (NumberFormatException ne) {
            throw new InvalidMathematicalExpressionException(InvalidMathematicalExpressionException.NOT_A_NUMBER);
        }
    }

    private Operator tokenToOperator(String token) {
        try {
            return Operator.from(token);
        } catch (OperatorException oe) {
            throw new InvalidMathematicalExpressionException(InvalidMathematicalExpressionException.WRONG_OPERATOR);
        }
    }

    public double getResult() {
        Double prev = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            Operator operator = operators.get(i);
            Double next = numbers.get(i + 1);
            prev = operator.calculate(prev, next);
        }
        return prev;
    }
}
