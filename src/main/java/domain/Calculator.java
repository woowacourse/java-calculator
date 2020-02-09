package domain;

public class Calculator {

    private final Formulas formulas;

    public Calculator(Formulas formulas) {
        this.formulas = formulas;
    }

    public int stringCalculate() {
        double result = new CastNumber(formulas.get(0)).getValue();
        int formulasSize = formulas.size();
        for (int index = 1; index < formulasSize; index += 2) {
            result = calculate(formulas.get(index),
                result, (double) new CastNumber(formulas.get(index + 1)).getValue());
        }
        return (int) result;
    }

    private double calculate(String operator, Double num1, Double num2) {
        double result = 0.0;
        boolean sameOperator = false;
        for (Operator compareOperator : Operator.values()) {
            result += compareOperator.sameOperatorCalculate(operator, num1, num2);
            sameOperator = (sameOperator || compareOperator.isSameOperator(operator));
        }
        if (sameOperator == false) {
            throw new IllegalArgumentException(
                "올바른 연산자를 입력하지 않으셨습니다. (입력한 연산자 : " + operator + ")");
        }
        return result;
    }
}
