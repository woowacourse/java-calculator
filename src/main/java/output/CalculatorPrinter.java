package output;

import expression.Expression;

public class CalculatorPrinter {

    private static final String RESULT_FORMATTED_STRING = "결과: %f";

    public static void print(Expression expression) {
        System.out.println(String.format(RESULT_FORMATTED_STRING, expression.getResult()));
    }
}
