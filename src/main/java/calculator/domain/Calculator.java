package calculator.domain;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.InputMismatchException;

public class Calculator {
    public void start() {
        while (true) {
            try {
                Equation equation = inputEquation();
                OutputView.printResult(getResult(equation));
                break;
            } catch (InputMismatchException | ArithmeticException | IllegalArgumentException e) {
                continue;
            }
        }
    }

    private Equation inputEquation() {
        return EquationHandler.handleRawEquation(InputView.inputEquation());
    }

    private int getResult(Equation equation) {
        return equation.calculate();
    }
}
