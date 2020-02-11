package exception;

import java.util.List;
import java.util.regex.Pattern;

public class ValidationCheck {
    private final String PATTERN = "(^[0-9]*$)";
    private final String PATTS = "^[+\\-\\*/]$";

    public boolean isNumber(List<String> nums) {
        boolean check = true;
        for (String num : nums) {
            check = check && isMatch(PATTERN, num);
        }
        return check;
    }

    public boolean isValidOperator(List<String> opers) {
        for(String oper : opers) {
            if(!isMatch(PATTS, oper)){
                return false;
            }
        }
        return true;
    }

    public boolean isMatch(String pattern, String target) {
        return Pattern.matches(pattern, target);
    }
}
