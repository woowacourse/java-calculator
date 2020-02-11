package calculator;

import java.util.function.BiFunction;

public enum Operator {
    ADD("+",
            (Double firstOperand, Double secondOperand) -> firstOperand + secondOperand),
    SUBTRACT("-",
            (Double firstOperand, Double secondOperand) -> firstOperand - secondOperand),
    MULTIPLY("*",
            (Double firstOperand, Double secondOperand) -> firstOperand * secondOperand),
    DIVIDE("/",
            (Double firstOperand, Double secondOperand) -> firstOperand / secondOperand);

    String operatorString;
    BiFunction<Double, Double, Double> function;

    Operator(String operatorString, BiFunction<Double, Double, Double> function) {
        this.operatorString = operatorString;
        this.function = function;
    }

    private String getOperatorString() {
        return this.operatorString;
    }

    public static Operator getOperatorByString(String operatorString) {
        for (Operator operator : Operator.values()) {
            if (operatorString.equals(operator.getOperatorString())) {
                return operator;
            }
        }
        throw new IllegalArgumentException("사칙연산자가 아닌 문자열 입력");
    }
}
