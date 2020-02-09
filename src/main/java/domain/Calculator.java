package domain;

public class Calculator {
    private static final int INDEX_INIT = 1;
    private static final int EVEN = 0;
    private static final int ODD = 1;
    static double returnValue;
    static String nowSign;

    public static double run(String input) {
        String[] values = input.split(" ");
        returnValue = Double.parseDouble(values[0]);
        for (int i = INDEX_INIT; i < values.length; i++) {
            checkStep(i, values[i]);
        }
        return returnValue;
    }

    private static void checkStep(int i, String value) {
        if (isEven(i) == true) {
            returnValue = Operator.calculate(nowSign, returnValue, Double.parseDouble(value));
            return;
        }
        nowSign = value;
    }

    private static boolean isEven(int i) {
        if (i % 2 == EVEN) {
            return true;
        }
        return false;
    }
}