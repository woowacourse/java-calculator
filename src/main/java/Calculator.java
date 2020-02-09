import jdk.internal.util.xml.impl.Input;

public class Calculator {
    private final int FIRST = 0;
    private double result = 0;

    void calculate(InputValues inputValues) {
        int length = inputValues.getValuesLength();
        double nextNumber = 0;

        result = Double.parseDouble(inputValues.getValueByIndex(FIRST));
        Operator nowOperator = null;
        for (int i = 1; i < length; i += 2) {
            nowOperator = Operator.getOperatorByString(inputValues.getValueByIndex(i));
            nextNumber = Double.parseDouble(inputValues.getValueByIndex(i + 1));
            result = nowOperator.operate(result, nextNumber);
        }
    }


    void printResult() {
        System.out.print("결과: " + result);
    }
}
