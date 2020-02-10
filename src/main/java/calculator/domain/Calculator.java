package calculator.domain;

import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    private static final int INDEX_INIT = 1;
    private static final int FIRST_VALUE_INDEX = 0;
    private static final int EVEN_NUMBER = 0;
    private static final int ODD_NUMBER = 1;
    private static final String DELIMITER = " ";
    static double returnValue;
    static String nowSign;

    public void setNowSign(String sign) {
        this.nowSign = sign;
    }

    public void setReturnValue(double returnValue) {
        this.returnValue = returnValue;
    }

    public double getReturnValue() {
        return this.returnValue;
    }

    public String getNowSign() {
        return this.nowSign;
    }

    public static void run() {
        String[] values = InputView.inputHandler().split(DELIMITER);
        returnValue = Double.parseDouble(values[FIRST_VALUE_INDEX]);
        selectOddNumberOrEvenNumber(values);
        OutputView.printResult(returnValue);
    }

    public static void selectOddNumberOrEvenNumber(String[] values) {
        for (int i = INDEX_INIT; i < values.length; i++) {
            calculateEvenNumber(i, values[i]);
            calculateOddNumber(i, values[i]);
        }
    }

    public static boolean isOdd(int number) {
        return number % 2 == ODD_NUMBER;
    }

    public static boolean isEven(int number) {
        return number % 2 == EVEN_NUMBER;
    }

    public static void calculateOddNumber(int index, String value) {
        if (isOdd(index)) {
            nowSign = value;
        }
    }

    public static void calculateEvenNumber(int index, String value) {
        if (isEven(index)) {
            selectOperators(Double.parseDouble(value));
        }
    }

    public static void selectOperators(double nowNumber) {
        for (Operator operators : Operator.values()) {
            calculateNumber(operators, nowNumber);
        }
    }

    public static void calculateNumber(Operator operators, double nowNumber) {
        if (operators.getOperator().equals(nowSign)) {
            operators.calculate(nowNumber);
        }
    }

}