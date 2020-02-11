package exception;

import java.util.regex.Pattern;

public class ValidationCheck {
    private final String PATTERN = "(^[0-9]*$)";
    private final String PATTS = "^[+\\-\\*/]$";

    public boolean isValid(String[] expressions) {
        for(int i = 0; i < expressions.length; i++) {
            if (checkValidation(expressions, i)) return false;
        }
        return true;
    }

    private boolean checkValidation(String[] expressions, int i) {
        if(i % 2 == 0) {
            if(!isNumber(expressions[i])) {
                System.out.println("not numbers");
                return false;
            }
        }
        else if(i % 2 == 1) {
            if(!isValidOperator(expressions[i])) {
                System.out.println("not operators");
                return false;
            }
        }
        return true;
    }

    public boolean isNumber(String number) {
        if(!isMatch(PATTERN, number)) {
            return false;
        }
        return true;
    }

    public boolean isValidOperator(String operator) {
        if(!isMatch(PATTS, operator)){
            return false;
        }
        return true;
    }

    public boolean isMatch(String pattern, String target) {
        return Pattern.matches(pattern, target);
    }
}
