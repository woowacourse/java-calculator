package calculator;

public class Operator {
    private String value;
    private enum OperatorType {
        ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/");

        private String operatorType;

        OperatorType(String operatorType) {
            this.operatorType = operatorType;
        }

        public String getOperatorType() {
            return this.operatorType;
        }
    }

    public Operator(String input) {
        value = input;
    }

    public static boolean isOperator(String input) {
        return input.equals(OperatorType.ADD.getOperatorType())
                || input.equals(OperatorType.SUBTRACT.getOperatorType())
                || input.equals(OperatorType.MULTIPLY.getOperatorType())
                || input.equals(OperatorType.DIVIDE.getOperatorType());
    }

    public double operate(double firstValue, double secondValue) {

        if (value.equals(OperatorType.ADD.getOperatorType())) {
            return firstValue + secondValue;
        }

        if (value.equals(OperatorType.SUBTRACT.getOperatorType())) {
            return firstValue - secondValue;
        }

        if (value.equals(OperatorType.MULTIPLY.getOperatorType())) {
            return firstValue * secondValue;
        }

        return firstValue / secondValue;
    }
}
