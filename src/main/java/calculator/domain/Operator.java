package calculator.domain;

import java.util.function.Function;

enum Operator {
    PLUS("+", nowNumber -> Calculator.returnValue += nowNumber),
    MINUS("-", nowNumber -> Calculator.returnValue -= nowNumber),
    MULTIPLY("*", nowNumber -> Calculator.returnValue *= nowNumber),
    DIVIDE("/", nowNumber -> Calculator.returnValue /= nowNumber);

    private String operator;
    private Function<Double, Double> expression;

    Operator(String operator, Function<Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public double calculate(double nowNumber){
        return expression.apply(nowNumber);
    }

    public String getOperator(){
        return this.operator;
    }

}