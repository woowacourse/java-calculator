package expression;

import calculator.Operator;

import java.util.ArrayList;
import java.util.List;

public class Expression {

    private List<Double> numbers = new ArrayList<>();
    private List<Operator> operators = new ArrayList<>();

    public Expression(String expression) {
        String[] tokens = expression.split(" ");

        validate(tokens);

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
            Operator operator = operators.get(i);
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
            throw new IllegalArgumentException();
        }
    }

    private Operator tokenToOperator(String token) {
        return Operator.from(token);
    }
}
