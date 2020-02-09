package calculator;

public class Validator {
    public boolean isValidInput(String input) {
        if (isNull(input) || isBlank(input) || isEmpty(input)) {
            return false;
        }
        return true;
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

    public boolean isValidSplitedInput(String[] splitedInput) {
        if (!IsDoubleNumber(splitedInput[0])) {
            return false;
        }
        for (int i = 1; i < splitedInput.length; i = i + 2) {
            String operator = splitedInput[i];
            String number = splitedInput[i + 1];
            if (operator.equals("/") && number.equals("0")) {
                return false;
            }
            if (!IsOperator(operator) || !IsDoubleNumber(number)) {
                return false;
            }
        }
        return true;
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
        for (Operator o : Operator.values()){
            if (o.getOperator().equals(operator)){
                return true;
            }
        }
        return false;
    }
}
