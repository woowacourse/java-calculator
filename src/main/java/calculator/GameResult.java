package calculator;

import java.util.HashMap;
import java.util.function.BiFunction;

public class GameResult {
    private static double result;

    GameResult(String result) {
        this.result = Double.parseDouble(result);
    }

    void resultCalculator(String operator, String number) throws IllegalAccessException {
        result = Operator.map.get(Operator.of(operator)).apply(result, Double.parseDouble(number));
    }

    double getFinalResult() {
        return result;
    }
}
