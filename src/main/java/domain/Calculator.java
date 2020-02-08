package domain;

import static utils.Constant.*;
import utils.InputValidation;
import view.InputView;
import view.OutputView;

import java.util.*;

public class Calculator {
    private final List<Double> numbers = new ArrayList<>();
    private final List<Character> operators = new ArrayList<>();

    public Calculator() {
        operatorFunction.put('+', ADDITION);
        operatorFunction.put('-', SUBTRACTION);
        operatorFunction.put('*', MULTIPLICATION);
        operatorFunction.put('/', DIVISION);
    }

    public List<Double> getNumbers() {
        return numbers;
    }

    public List<Character> getOperators() {
        return operators;
    }

    public void run() {
        splitFormula(InputView.inputFormula());
        OutputView.printResult(calculate());
    }

    private void splitFormula(String formula) {
        String[] formulas = InputValidation.trimSpace(formula.split(" ", ZERO));

        for (int i = ZERO; i < formulas.length; i++) {
            String temp = formulas[i];
            if (i % EVEN == ZERO) {
                numbers.add(InputValidation.checkIsNumber(formulas[i]));
                continue;
            }
            operators.add(InputValidation.checkIsOperator(formulas[i]));
        }
    }

    private double calculate() {
        double result = numbers.remove(ZERO);
        for (char operator : operators) {
            result = operatorFunction.get(operator).apply(result, numbers.remove(ZERO));
        }
        return result;
    }
}
