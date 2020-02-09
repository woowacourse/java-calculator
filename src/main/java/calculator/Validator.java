package calculator;

public class Validator {
    public static final String ZERO = "0";
    public static final String BLANK = " ";

    public boolean isValidInput(String input) {
        if (isNull(input) || isBlank(input) || isEmpty(input)) {
            return false;
        }
        String[] splitInput = input.split(BLANK);
        if (!IsDoubleNumber(splitInput[0])) {
            return false;
        }
        for (int i = 1; i < splitInput.length; i = i + 2) {
            String operator = splitInput[i];
            String number = splitInput[i + 1];
            if (!IsOperator(operator) || !IsDoubleNumber(number) || isDivideZero(operator, number)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDivideZero(String operator, String number) {
        if (!Operator.DIVIDE.getOperator().equals(operator)) {
            return false;
        }
        return ZERO.equals(number);
    }

    private boolean isNull(String input) {
        return input == null;
    }

    private boolean isBlank(String input) {
        return input.equals(" ");
    }

    private boolean isEmpty(String input) {
        return input.equals("");
    }


    private boolean IsDoubleNumber(String s) {
        try {
            Double.valueOf(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean IsOperator(String operator) {
        for (Operator o : Operator.values()) {
            if (o.getOperator().equals(operator)) {
                return true;
            }
        }
        return false;
    }
}
