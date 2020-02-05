package com.woowacourse.calculator.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_EQUATION_GUIDE_MESSAGE = "수식을 입력해주세요 (e.g. 2 + 3 - 5): ";
    private static final Scanner SCANNER = new Scanner(System.in);

    // 묵시적 생성자 방지
    private InputView() {}

    public static String inputEquation() {
        System.out.print(INPUT_EQUATION_GUIDE_MESSAGE);
        return SCANNER.nextLine();
    }
}
