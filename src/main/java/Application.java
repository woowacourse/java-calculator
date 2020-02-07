import expression.Expression;

import java.util.Scanner;

public class Application {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("수식을 입력해주세요.(공백으로 구분)");
        String userExpression = scanner.nextLine();

        Expression expression = new Expression(userExpression);
        Double userResult = expression.getResult();

        System.out.println("결과 : " + userResult);
    }
}
