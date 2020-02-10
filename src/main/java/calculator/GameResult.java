package calculator;

import java.util.HashMap;
import java.util.function.BiFunction;

public class GameResult {
    private static double result;

    GameResult(String result) {
        this.result = Double.parseDouble(result);
    }

    void resultCalculator(String operator, String number) throws IllegalAccessException {
        if (operator.equals("/") && number.equals("0")) {
            throw new ArithmeticException();
        }
        result = Operator.map.get(Operator.of(operator)).apply(result, Double.parseDouble(number));
    }

    void setResult(double result) { this.result = result;}
    double getResult() {return result;}
    double getFinalResult() {
        return result;
    }
}
