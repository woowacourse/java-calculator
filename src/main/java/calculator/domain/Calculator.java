package calculator.domain;

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
        selectOddNumberOrEvenNumber(values);
        OutputView.printResult(returnValue);
    }

    public static void selectOddNumberOrEvenNumber(String[] values) {
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
            selectOperators(Double.parseDouble(value));
        }
    }

    public static void selectOperators(double nowNumber) {
        for(Operator operators : Operator.values()){
            calculateNumber(operators, nowNumber);
        }
    }

    public static void calculateNumber(Operator operators, double nowNumber){
        if(operators.getOperator().equals(nowSign)){
            operators.calculate(nowNumber);
        }
    }



}