package calculator;

import java.util.List;

public class Calculator {

    public static double calculate(Expression expression) {
        List<String> elements = expression.getReadOnlyElements();

        double firstElement = Double.parseDouble(elements.get(0));
        Operator operator =  null;
        double result = firstElement;

        for (int i = 1; i < elements.size(); i++) {
            if (i % 2 == 1) {
                operator = Operator.getOperator(elements.get(i));
            } else {
                double nextElement = Double.parseDouble(elements.get(i));
                result = operator.apply(result, nextElement);
            }
        }

        return result;
    }

}
