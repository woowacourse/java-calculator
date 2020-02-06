package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final String formula;
    private final List<Double> numbers = new ArrayList<>();
    private final List<Character> operators = new ArrayList<>();

    public Controller() {
        formula = InputView.inputFormula();
        // 스플릿
        // 계산
        // 출력
    }

    private void splitFormula() {

    }

    private double runCalculator() {
        double result = 0;

        return result;
    }

}
