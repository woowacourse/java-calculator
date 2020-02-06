package calculator;

import io.OutputView;

import java.util.HashMap;

public class GameResult {
    private static double result;
    private static HashMap<String, Operator> map = new HashMap<>();

    GameResult(String result) {
        this.result = Double.parseDouble(result);
    }

    static {
        map.put("+", new Add());
        map.put("-", new Subtract());
        map.put("*", new Multiply());
        map.put("/", new Divide());
    }

    void resultCalculator(String operator, String number) {
        result = map.get(operator).calculate(result, Double.parseDouble(number));
    }

    double getFinalResult() {
        return result;
    }
}
