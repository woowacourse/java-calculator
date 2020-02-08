package calculator;

public enum CalculatorType {
    PLUS("+", (a, b) -> (a + b)),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String operator;
    private final OperationMethod operationMethod;

    CalculatorType(String operator, OperationMethod operationMethod) {
        this.operator = operator;
        this.operationMethod = operationMethod;
    }

    public static int operate(int n1, int n2, String inputOperator) throws IllegalArgumentException{
        return findApplytoOperator(inputOperator).operationMethod.apply(n1, n2);
    }

    public static CalculatorType findApplytoOperator(String inputOperator) throws IllegalArgumentException{
        for(CalculatorType calculatorType : CalculatorType.values()){
            if(calculatorType.toString().equals(inputOperator)){
                return calculatorType;
            }
        }
        throw new IllegalArgumentException();
    }
    @Override
    public String toString(){
        return operator;
    }
}

@FunctionalInterface
interface OperationMethod {
    int apply(int n1, int n2);
}
