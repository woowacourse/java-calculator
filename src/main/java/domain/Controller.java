package domain;

import view.InputView;

import java.util.*;

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
        String[] formulas = formula.split(" ");
        for(int i = 0; i < formulas.length; i++){
            if(i % 2 == 0) {
                numbers.add(Double.parseDouble(formulas[i]));
                continue;
            }
            operators.add(formulas[i].charAt(0));
        }
    }

    private double runCalculator() {
        double result = 0;

        return result;
    }

}
