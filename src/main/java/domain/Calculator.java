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

    public int stringCalculate() {
        double result = new CastNumber(formulas.get(0)).getValue();
        for (int index = 1; index < formulas.size(); index += 2) {
            result = calculate(formulas.get(index),
                    result, (double) new CastNumber(formulas.get(index + 1)).getValue());
        }
        return (int) result;
    }

    private static double calculate(String operator, Double num1, Double num2) {
        if (operator.equals("/") && num2.intValue() == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        try {
            return operators.get(operator).apply(num1, num2);
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException("올바른 연산자를 입력하지 않으셨습니다. (입력한 연산자 : " + operator + ")");
        }
    }
}
