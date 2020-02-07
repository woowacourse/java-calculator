package calculator;

import domain.Expression;

import java.util.Scanner;

public class Calculator {
    public void run() {
        System.out.println("수식을 입력해주세요.(공백으로 구분)");

        Scanner scanner = new Scanner(System.in);
        String userExpression = scanner.nextLine();

        Expression expression = new Expression(userExpression);
        Double userResult = expression.getResult();

        System.out.println("결과 : " + userResult);
    }
}
