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
        Operator calculateOperator = Operator.findOperator(operator);
        return calculateOperator.calculate(num1, num2);
    }
}
