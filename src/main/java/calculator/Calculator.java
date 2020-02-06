package calculator;

import calculator.filter.EquationFilter;
import calculator.operator.OperatorGroup;
import calculator.spliter.StringSplitter;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Calculator {
    private final InputView inputView;
    private String equation;
    private Double result;

    public Calculator(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        init();
        operate();
        OutputView.showResult(result);
    }

    private void init() {
        try {
            this.equation = inputView.inputEquation();
        } catch (IllegalArgumentException e) {
            init();
        }
    }

    private void operate() {
        List<String> spiltedEquation = StringSplitter.stringSplitter(equation);
        Deque<Double> numbers = new LinkedList<>(EquationFilter.getNumbers(spiltedEquation));
        Queue<String> operators = new LinkedList<>(EquationFilter.getOperators(spiltedEquation));
        while (numbers.size() != 1) {
            numbers.addFirst(OperatorGroup.operate(numbers.pollFirst(), operators.poll(), numbers.pollFirst()));
        }
        result = numbers.getFirst();
    }
}
