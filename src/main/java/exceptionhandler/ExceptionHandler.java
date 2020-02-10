package exceptionhandler;

import calculator.Operator;

import java.util.List;
import java.util.regex.Pattern;

public class ExceptionHandler {
    private static final String NUMBER_PATTERN = "(^[0-9]*$)";

    public static boolean isNumber(List<String> nums) {
        boolean check = true;
        for (String num : nums) {
            check = check && isMatchNumber(num);
        }
        return check;
    }

    public static boolean isValidOperator(List<String> opers) {
        boolean check = true;
        for (String oper : opers) {
            check = check && Operator.isValidOperator(oper);
        }
        return check;
    }

    public static boolean isMatchNumber(String target) {
        return Pattern.matches(NUMBER_PATTERN, target);
    }
}
