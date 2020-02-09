package calculator;

import java.util.Scanner;

public class UserInput {
    private Check ch = new Check();
    private String equationDelimiter = " ";

    public String[] getInputEquation() {
        Scanner scanner = new Scanner(System.in);
        String[] equations;

        while(true) {
            try {
                String equation = scanner.nextLine();
                equations = equation.split(equationDelimiter);
                ch.checkEquationElementValue(equations);
                break;
            } catch(NumberFormatException e) {
                System.out.println("다시 입력해주세요");
            }
        }

        return equations;
    }
}
