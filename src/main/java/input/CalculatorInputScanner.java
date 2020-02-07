package input;

import java.util.Scanner;

public class CalculatorInputScanner {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getExpression() {
        System.out.println("수식을 입력해주세요.(공백으로 구분)");
        return scanner.nextLine();
    }

}
