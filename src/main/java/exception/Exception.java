package exception;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Exception {
    private static final String PATTERN = "(^[0-9]*$)";
    private static final String PATTS = "^[+\\-\\*/]$";

    public static boolean isNumber(List<String> nums) {
        boolean check = true;
        for (String num : nums) {
            check = check && isMatch(PATTERN, num);
        }
        return check;
    }

    public static boolean isValidOperator(List<String> opers) {     // 연산자가 들어갈 인덱스에 연산자 외의 값이 들어가 있는지 확인.
        boolean check = true;
        for(String oper : opers) {
            check = check && isMatch(PATTS, oper);
        }
        return check;
    }

    public static boolean isMatch(String pattern, String target) {  // 각 정규식에 맞게 검사.
        if(!Pattern.matches(pattern, target)){
            return false;
        }
        return true;
    }
}
