package calculator;

import io.OutputView;

import java.util.HashMap;

public class GameResult {
    private static double result;
    private static HashMap<Character, Operator> map = new HashMap<>();

    static {
        map.put('+', new Add());
        map.put('-', new Subtract());
        map.put('*', new Multiply());
        map.put('/', new Divide());
    }

    GameResult(String result) {
        this.result = Double.parseDouble(result);
    }

    void resultCalculator(String operator, String number) {
        result = map.get(operator.charAt(0)).calculate(result, Double.parseDouble(number));
    }

    void getFinalResult() {
        OutputView.answer(result);
    }
}
