package domain;

import view.InputView;
import view.OutputView;

import java.util.*;
import java.util.function.BiFunction;

public class Calculator {

    private final List<Double> numbers = new ArrayList<>();
    private final List<Character> operators = new ArrayList<>();
    private final BiFunction<Double, Double, Double> ADDITION = (a, b) -> a + b;
    private final BiFunction<Double, Double, Double> SUBTRACTION = (a, b) -> a - b;
    private final BiFunction<Double, Double, Double> MULTIPLICATION = (a, b) -> a * b;
    private final BiFunction<Double, Double, Double> DIVISION = (a, b) -> a / b;
    private final Map<Character, BiFunction<Double, Double, Double>> calculateFunctionMap = new HashMap<>();


    public List<Double> getNumbers() {
        return numbers;
    }

    public List<Character> getOperators() {
        return operators;
    }

    public Calculator() {
        calculateFunctionMap.put('+', ADDITION);
        calculateFunctionMap.put('-', SUBTRACTION);
        calculateFunctionMap.put('*', MULTIPLICATION);
        calculateFunctionMap.put('/', DIVISION);
    }

    public void run() {
        splitFormula(InputView.inputFormula());
        OutputView.printResult(calculate());
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

    public double calculate() {
        double result = numbers.remove(0);
        for (char operator : operators) {
            result = calculateFunctionMap.get(operator).apply(result, numbers.remove(0));
        }
        return result;
    }
}
