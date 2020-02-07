package calculator;

public class Operator {
    private String value;

    public Operator(String input) {
        value = input;
    }

    public boolean isAdd() {

        if (value.equals("+")) {
            return true;
        }

        return false;
    }

    public boolean isSubtract() {

        if (value.equals("-")) {
            return true;
        }

        return false;
    }

    public boolean isMultiply() {

        if (value.equals("*")) {
            return true;
        }

        return false;
    }

    public boolean isDivide() {

        if (value.equals("/")) {
            return true;
        }

        return false;
    }
}
