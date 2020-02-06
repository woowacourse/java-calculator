package calculator;

import calculator.view.InputView;

import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new InputView(new Scanner(System.in)));
        calculator.run();
    }
}
