import java.util.Scanner;

public class Calculator {
    static int returnValue;
    private static final int INDEX_INIT = 1;
    private static final int EVEN = 0;
    private static final int ODD = 1;
    private static Scanner scanner = new Scanner(System.in);
    private static String nowSign;

    public static void main(String args[]) {
        String[] values = scanner.nextLine().split(" ");
        returnValue = Integer.parseInt(values[0]);
        for (int i = INDEX_INIT; i < values.length; i++) {
            check(i, values[i]);
        }
        System.out.println(returnValue);
    }

    private static void check(int i, String value) {
        if (i % 2 == EVEN) {
            calculate(Integer.parseInt(value));
        }
        if (i % 2 == ODD) {
            nowSign = value;
        }
    }

    private static void calculate(int nowNumber) {
        if (nowSign.equals("+")) {
            //덧셈 함수
            return;
        }
        if (nowSign.equals("-")) {
            //뺄셈 함수
            return;
        }
        if (nowSign.equals("*")) {
            //곱하기 함수
            return;
        }
        if (nowSign.equals("/")) {
            //더하기 함수
            return;
        }
    }
}
