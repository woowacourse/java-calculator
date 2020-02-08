package com.woowacourse.calculator.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public String inputExpression() {
        System.out.println("식을 입력해 주세요.");
        return scanner.nextLine();
    }
}
