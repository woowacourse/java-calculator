public class Calculator {
    private static final int FIRST = 0;
    private static final int TWO = 2;
    private double result = 0;

    void calculate(InputValues inputValues) {
        Input input = inputValues.getInput();
        int length = input.getValuesLength();
        double nextNumber;

        result = Double.parseDouble(input.getValueByIndex(FIRST));
        Operator nowOperator;
        for (int i = 1; i < length; i += TWO) {
            nowOperator =
                    Operator.getOperatorByString(input.getValueByIndex(i));
            nextNumber = Double.parseDouble(input.getValueByIndex(i + 1));
            result = nowOperator.operate(result, nextNumber);
        }
    }

    double getResult(){
        return result;
    }
}
