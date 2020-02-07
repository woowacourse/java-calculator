package view;

import java.util.Scanner;

public class InputView {
    static Scanner SCANNER = new Scanner(System.in);

    public static String enterMathematicalExpression() {
        System.out.print("수식을 입력해주세요: ");
        return SCANNER.nextLine();
    }

    public static boolean enterYesNo() {
        try {
            System.out.println("계속 계산하시겠습니까? y 또는 n을 입력해주세요");
            return YesNo.valueOf(SCANNER.nextLine()).toBoolean();
        } catch (IllegalArgumentException e) {
            System.out.println("y 또는 n만 입력해주세요");
            return enterYesNo();
        }
    }
}
