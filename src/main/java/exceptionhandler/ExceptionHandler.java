package exceptionhandler;

import java.util.List;
import java.util.regex.Pattern;

public class ExceptionHandler {
    private static final String NUMBER_PATTERN = "(^[0-9]*$)";
    private static final String OPERATION_PATTERN = "^[+\\-\\*/]$";

    public static boolean isNumber(List<String> nums) {
        boolean check = true;
        for (String num : nums) {
            check = check && isMatch(NUMBER_PATTERN, num);
        }
        return check;
    }

    public static boolean isValidOperator(List<String> opers) {
        boolean check = true;
        for (String oper : opers) {
            check = check && isMatch(OPERATION_PATTERN, oper);
        }
        return check;
    }

    public static boolean isMatch(String pattern, String target) {
        if (!Pattern.matches(pattern, target)) {
            return false;
        }
        return true;
    }
}
