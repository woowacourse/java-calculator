package domain;

import view.InputView;
import view.OutputView;

import java.util.*;

public class Controller {

    public List<Double> getNumbers() {
        return numbers;
    }

    public List<Character> getOperators() {
        return operators;
    }

    private final List<Double> numbers = new ArrayList<>();
    private final List<Character> operators = new ArrayList<>();

    public void run() {
        splitFormula(InputView.inputFormula());
        OutputView.printResult(runCalculator());
    }

    public void splitFormula(String formula) {
        String[] formulas = formula.split(" ");
        for (int i = 0; i < formulas.length; i++) {
            if (i % 2 == 0) {
                numbers.add(Double.parseDouble(formulas[i]));
                continue;
            }
            operators.add(formulas[i].charAt(0));
        }
    }

    public double runCalculator() {
        double result = numbers.remove(0);
        for (char operator : operators) {
            double target = numbers.remove(0);
            if (operator == '+')
                result = Calculator.addition(result, target);
            if (operator == '-')
                result = Calculator.subtraction(result, target);
            if (operator == '*')
                result = Calculator.multiplication(result, target);
            if (operator == '/')
                result = Calculator.division(result, target);
        }
        return result;
    }
}
