package utils;

import static utils.Constant.*;

public class Exit {
    static public void sendErrorMessage(String message) {
        System.out.println(message);
        System.out.println("프로그램을 종료합니다.");
        System.exit(ZERO);
    }
}
