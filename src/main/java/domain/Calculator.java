package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
    private static Map<String, BiFunction<Double, Double, Double>> operators = new HashMap<>();

    private final Formulas formulas;
    static {
        operators.put("+", (num1, num2) -> num1 + num2);
        operators.put("-", (num1, num2) -> num1 - num2);
        operators.put("*", (num1, num2) -> num1 * num2);
        operators.put("/", (num1, num2) -> num1 / num2);
    }

    public Calculator(Formulas formulas) {
        this.formulas = formulas;
    }

    public int startCalculate() {
        double result = checkNumbers(formulas.get(0));
        for (int index = 1; index < formulas.size(); index += 2) {
            result = calculate(checkOperator(formulas.get(index)),
                    result, checkNumbers(formulas.get(index + 1)));
        }
        return (int) result;
    }

    private double checkNumbers(String number) {
        if (!number.matches("^[0-9\\+\\-]?[0-9]+$")) {
            throw new IllegalArgumentException("잘못된 계산식 - 피연산자가 숫자가 아님 : " + number);
        }
        return Double.parseDouble(number);
    }

    private String checkOperator(String operator) {
        if (operator.matches("^[\\+\\-\\*\\/]$")) {
            return operator;
        }
        throw new IllegalArgumentException("잘못된 계산식 - 연산자가 잘못됨 : " + operator);
    }

    private double calculate(String operator, Double num1, Double num2) {
        if (operator.equals("/") && num2.intValue() == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return operators.get(operator).apply(num1, num2);
    }
}
