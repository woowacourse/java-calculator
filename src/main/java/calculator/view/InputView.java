package calculator.view;

import calculator.ElementValidator;

import java.util.Scanner;

public class InputView {
    private static final String EQUATION_DELIMITER = " ";
    private ElementValidator validator = new ElementValidator();

    public String[] getInputEquation() {
        Scanner scanner = new Scanner(System.in);
        String[] equations;

        while(true) {
            try {
                String equation = scanner.nextLine();
                equations = equation.split(EQUATION_DELIMITER);
                validator.checkEquationElementValue(equations);
                break;
            } catch(NumberFormatException e) {
                System.out.println("다시 입력해주세요");
            }
        }

        return equations;
    }
}
