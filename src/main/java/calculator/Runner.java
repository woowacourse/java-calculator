package calculator;

import java.util.Scanner;

public class Runner {
    Expression expression;
    final int ONE_TIME_INPUT_SUCCESS = 1;
    final int ONE_TIME_INPUT_FAILED = 2;

    public void run() {

        // 입력값이 조건에 맞지 않는 경우 사용자에게 다시 입력을 요청함
        while (oneTimeInput(getInput()) == ONE_TIME_INPUT_FAILED);

        View.printResult(Calculator.calculate(expression));
    }

    private String getInput() {
        System.out.print("계산할 문자열을 입력해 주세요: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int oneTimeInput(String inputString) {

        try {
            expression = new Expression(inputString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ONE_TIME_INPUT_FAILED;
        }

        return ONE_TIME_INPUT_SUCCESS;
    }
}
