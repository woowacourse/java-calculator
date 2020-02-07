package view;

import java.util.Scanner;

public class InputView {
    static Scanner SCANNER = new Scanner(System.in);

    public static String enterMathematicalExpression () {
        System.out.print("수식을 입력해주세요: ");
        return SCANNER.nextLine();
    }
}
