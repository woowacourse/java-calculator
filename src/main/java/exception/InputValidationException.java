package exception;

import view.InputView;

public class InputValidationException {

    public static boolean checkNullOroSpace(String input) {
        if (input.equals(null) || input.equals(" ")) {
            System.out.println("공백을 입력하셨습니다.");
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }
        return false;
    }

    public static double checkIsNumber(String stringNubmer) {
        try {
            return Double.parseDouble(stringNubmer);
        }catch (Exception e){
            System.out.println("오류");
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }
        return -1;
    }
}
