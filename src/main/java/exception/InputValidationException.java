package exception;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class InputValidationException {

    public static boolean checkNullOroSpace(String input) {
        if (input.equals(null) || input.equals(" ")) {
            System.out.println("공백을 입력하셨습니다.");
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }
        return false;
    }

    public static double checkIsNumber(String stringNumber) {
        try {
            return Double.parseDouble(stringNumber);
        } catch (Exception e) {
            System.out.println("오류");
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }
        return -1;
    }

    public static char checkIsOperator(String stringOperator) {
        char operator = stringOperator.charAt(0);
        List<Character> operators = new ArrayList<>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');

        if (!operators.contains(operator)
                || stringOperator.length() != 1) {
            System.out.println("오류");
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }
        return operator;
    }
}
