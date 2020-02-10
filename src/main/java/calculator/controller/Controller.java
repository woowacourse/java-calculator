package calculator.controller;

import calculator.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {
    private OutputView output = new OutputView();
    private InputView input = new InputView();
    private Calculator calculator = new Calculator();

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
    }

    private void run() {
        String[] equations = input.getInputEquation();
        int queueSize = calculator.divideEquationIntoOperandsOperator(equations);
        double result = calculator.checkOperatorAndCalculate(queueSize);
        output.showResult(result);
    }

}
