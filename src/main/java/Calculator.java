public class Calculator {
    private final int FIRST = 0;
    private double result = 0;

    void calculate() {
        int length = StringValue.getValuesLength();
        double nextNumber = 0;

        result = Double.parseDouble(StringValue.getValueByIndex(FIRST));
        Operator nowOperator = null;
        for (int i = 1; i < length; i += 2) {
            nowOperator = Operator.getOperatorByString(StringValue.getValueByIndex(i));
            nextNumber = Double.parseDouble(StringValue.getValueByIndex(i + 1));
            result = nowOperator.operate(result, nextNumber);
        }

        OutView.printResult(result);
    }
}
