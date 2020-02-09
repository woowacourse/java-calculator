package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;
import calculator.view.dto.RawEquationDTO;

import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        RawEquationDTO inputEquation = new InputView(new Scanner(System.in)).inputEquation();
        OutputView.showResult(calculator.run(inputEquation));
    }
}
