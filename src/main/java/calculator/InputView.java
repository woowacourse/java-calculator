package calculator;

import java.util.Scanner;

public class InputView {

    public static void askInput() {
        System.out.print(
                "[ 문자열 계산기 ]\n" +
                        "- - - - - 계산할 문자열 입력 규칙 - - - - -\n" +
                        " * 1번째, 3번째, 5번째 등 홀수번째 문자는 숫자만 올 수 있습니다.\n" +
                        " * 2번째, 4번째, 6번째 등 짝수번째 문자는 연산자(+, -, *, /)만 올 수 있습니다.\n" +
                        " * 마지막 문자는 숫자여야 합니다.\n" +
                        " * 각 문자들 사이에는 한 칸의 공백이 존재해야 하며, " +
                        "문장의 시작과 끝에는 공백이 없어야 합니다.\n" +
                        "- - - - - - - - - - - - - - - - - - - - - - - - - - -\n");

        System.out.print("계산할 문자열을 입력해 주세요 ▶︎ ");
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
