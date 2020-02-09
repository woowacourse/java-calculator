package calculator;

public class Operator {
    static final String PLUS = "+";
    static final String MINUS = "-";
    static final String MULTIPLY = "*";
    static final String DIVIDE = "/";


    public double operate(String operator, double x, double y) {
        if(operator.equals(PLUS)) { return x + y; }
        if(operator.equals(MINUS)) { return x - y; }
        if(operator.equals(MULTIPLY)) { return x * y; }
        return x / y;
    }
}
