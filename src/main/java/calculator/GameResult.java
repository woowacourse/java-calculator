package calculator;

import java.util.HashMap;
import java.util.function.BiFunction;

public class GameResult {
    private static double result;

    private static HashMap<Operator, BiFunction<Double, Double, Double>> map = new HashMap<Operator, BiFunction<Double, Double, Double>>();

    GameResult(String result) {
        this.result = Double.parseDouble(result);
    }

    static {
        map.put(Operator.PLUS, (a, b) -> a + b);
        map.put(Operator.SUBTRACT, (a, b) -> a - b);
        map.put(Operator.MULTIPLY, (a, b) -> a * b);
        map.put(Operator.DIVIDE, (a, b) -> a / b);
    }

    void resultCalculator(String operator, String number) throws IllegalAccessException {
        if (operator.equals("/") && number.equals("0")) {
            throw new ArithmeticException();
        }
        result = map.get(Operator.of(operator)).apply(result, Double.parseDouble(number));
    }

    double getFinalResult() {
        return result;
    }
}
