package calculator;

import java.util.Scanner;

public class Runner {
    public void run() {
        Expression expression = null;

        // 입력값이 올바른 연산식(expression)이 아닐 경우 사용자에게 다시 입력을 요청함
        do {
            expression = oneTimeInput(getInput());
        } while (expression == null);

        View.printResult(Calculator.calculate(expression));
    }

    private String getInput() {
        System.out.print("계산할 문자열을 입력해 주세요: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private Expression oneTimeInput(String inputString) {

        try {
            return new Expression(inputString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
