package application.input;

import application.calculator.Calculator;

import java.util.Scanner;

public class InputEquation {

    private static final String BLANK = " ";

    public String[] getInputEquation() {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String[] equations;

        while(true) {
            try {
                String equation = scanner.nextLine();
                equations = equation.split(BLANK);
                calculator.checkEquationElementValue(equations);
                break;
            } catch(NumberFormatException e) {
                System.out.println("다시 입력해주세요");
            }
        }
        return equations;
    }
}
