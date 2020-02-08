package domain;

import calculator.calculate.*;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private List<Double> numbers = new ArrayList<>();
    private List<Calculatable> operators = new ArrayList<>();

    public Expression(String expression) {
        String[] tokens = expression.split(" ");

        validate(tokens);
        parseTokens(tokens);
    }

    private void parseTokens(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            if (isNumberIndex(i)) {
                numbers.add(tokenToDouble(tokens[i]));
            }
            if (isOperatorIndex(i)) {
                operators.add(tokenToOperator(tokens[i]));
            }
        }
    }

    public double getResult() {
        Double prev = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            Calculatable operator = operators.get(i);
            Double next = numbers.get(i + 1);
            prev = operator.calculate(prev, next);
        }
        return prev;
    }

    private void validate(String[] tokens) {
        if (tokens.length % 2 == 0) {
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException("항의 자리엔 숫자가 와야합니다.");
        }
    }

    private Calculatable tokenToOperator(String token) {
        if (Operator.PLUS.isPlusSymbol(token)) {
            return new Plus();
        }
        if (Operator.MINUS.isMinusSymbol(token)) {
            return new Minus();
        }
        if (Operator.MULTIPLY.isMultiplySymbol(token)) {
            return new Multiply();
        }
        if (Operator.DIVIDE.isDivideSymbol(token)) {
            return new Divide();
        }
        throw new IllegalArgumentException("올바른 연산자가 아닙니다.");
    }
}
