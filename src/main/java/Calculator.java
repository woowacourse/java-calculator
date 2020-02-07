public class Calculator {
    private final int FIRST = 0;
    private double result = 0;

    void calculate() {
        int length = InputValues.getValuesLength();
        double nextNumber = 0;

        result = Double.parseDouble(InputValues.getValueByIndex(FIRST));
        Operator nowOperator = null;
        for (int i = 1; i < length; i += 2) {
            nowOperator = Operator.getOperatorByString(InputValues.getValueByIndex(i));
            nextNumber = Double.parseDouble(InputValues.getValueByIndex(i + 1));
            result = nowOperator.operate(result, nextNumber);
        }
    }


    void printResult() {
        System.out.print("결과: " + result);
    }
}
