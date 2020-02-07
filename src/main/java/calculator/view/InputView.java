package calculator.view;

import java.util.Scanner;

public class InputView {

    public static String inputEquation() {
        System.out.println("계산할 수식을 입력해주세요. (숫자와 연산자는 공백으로 구분)");
        System.out.println("예시> 1 + 2");
        String equation = new Scanner(System.in).nextLine();
        validate(equation);
        return equation;
    }

    private static void validate(String equation) {
        if (equation.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 문자열");
        }
    }
}
