package io;

import java.util.Scanner;

public class ConsoleInput {
    private Scanner scanner = new Scanner(System.in);

    public String inputExpression() {
        System.out.println("수식을 입력해주세요.(공백으로 구분)");
        return scanner.nextLine();
    }
}
