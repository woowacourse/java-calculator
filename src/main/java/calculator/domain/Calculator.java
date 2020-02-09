package calculator.domain;

import calculator.util.ExceptionHandler;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    private static final int INDEX_INIT = 1;
    private static final int EVEN = 0;
    private static final int ODD = 1;
    static double returnValue;
    static String nowSign;

    public static void run() {

        String[] values = InputView.inputHandler().split(" ");
        returnValue = Double.parseDouble(values[0]);

        calculateNumber(values);

        OutputView.printResult(returnValue);
    }

    public static void calculateNumber(String[] values) {
        for (int i = INDEX_INIT; i < values.length; i++) {
            calculateEvenNumber(i, values[i]);
            calculateOddNumber(i,values[i]);
        }
    }

    public static void calculateOddNumber(int index, String value){
        if (index % 2 == ODD) {
            nowSign = value;
        }
    }

    public static void calculateEvenNumber(int index, String value){
        if (index % 2 == EVEN) {
            calculate(Double.parseDouble(value));
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