package calculator.domain;

import calculator.util.ExceptionHandler;

public class Calculator {
    private static final int INDEX_INIT = 1;
    private static final int EVEN = 0;
    private static final int ODD = 1;
    static double returnValue;
    static String nowSign;

    public static void main(String args[]) {
        String[] values = ExceptionHandler.inputHandler().split(" ");
        returnValue = Double.parseDouble(values[0]);
        for (int i = INDEX_INIT; i < values.length; i++) {
            check(i, values[i]);
        }

        if (returnValue == Math.round(returnValue)) {
            System.out.println(Math.round(returnValue));
            return;
        }
        System.out.println(returnValue);
    }

    public static void check(int i, String value) {
        if (i % 2 == EVEN) {
            calculate(Double.parseDouble(value));
        }
        if (i % 2 == ODD) {
            nowSign = value;
        }
    }

    public static void calculate(double nowNumber) {
        if (nowSign.equals("+")) {
            plus(nowNumber);
            return;
        }
        if (nowSign.equals("-")) {
            minus(nowNumber);
            return;
        }
        if (nowSign.equals("*")) {
            multiply(nowNumber);
            return;
        }
        if (nowSign.equals("/")) {
            divide(nowNumber);
            return;
        }
    }

    public static void plus(double nowNumber) {
        returnValue += nowNumber;
    }

    public static void minus(double nowNumber) {
        returnValue -= nowNumber;
    }

    public static void multiply(double nowNumber) {
        returnValue *= nowNumber;
    }

    public static void divide(double nowNumber) {
        returnValue /= nowNumber;
    }
}