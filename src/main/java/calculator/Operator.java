package calculator;

public class Operator {

    public static final int ADD_TYPE = 1;
    public static final int SUBTRACT_TYPE = 2;
    public static final int MULTIPLY_TYPE = 3;
    public static final int DIVIDE_TYPE = 4;
    private String value;

    public Operator(String input) {
        value = input;
    }

    public int getType() {

        if (value.equals("+")) {
            return ADD_TYPE;
        }

        if (value.equals("-")) {
            return SUBTRACT_TYPE;
        }

        if (value.equals("*")) {
            return MULTIPLY_TYPE;
        }

        return DIVIDE_TYPE;
    }
}
