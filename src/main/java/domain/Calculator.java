package domain;

import utils.EvenChecker;

public class Calculator {
    private static final int INDEX_INIT = 1;

    public static double run(String input) {
        String[] values = input.split(" ");
        StringValue stringValue = new StringValue(Double.parseDouble(values[0]), "");
        for (int i = INDEX_INIT; i < values.length; i++) {
            checkStep(i, values[i], stringValue);
        }
        return stringValue.returnValue;
    }

    private static void checkStep(int i, String value, StringValue stringValue) {
        if (EvenChecker.isEven(i)) {
            stringValue.returnValue = Operator.calculate(stringValue.nowSign, stringValue.returnValue, Double.parseDouble(value));
            return;
        }
        stringValue.nowSign = value;
    }
}