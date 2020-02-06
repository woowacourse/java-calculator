package calculator;

import java.util.Scanner;

public class Calculator {
    public void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run();
    }

    private void run() {
        String[] equation = getEquation();
    }

    private String[] getEquation() {
        Scanner scanner = new Scanner(System.in);
        String equation = scanner.nextLine();
        return equation.split(" " );
    }

}
