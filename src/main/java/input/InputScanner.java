package input;

import java.util.Scanner;

public class InputScanner {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String ASK_EXPRESSION_STATEMENT = "수식을 입력해주세요.(숫자와 연산자는 공백으로 구분";

    public static String getExpression() {
        System.out.println(ASK_EXPRESSION_STATEMENT);
        return scanner.nextLine();
    }

}
