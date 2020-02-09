package domain;

import java.util.Queue;

public class Calculator {
    public static int calculateByFormulas(Formulas formulas) {
        Queue<String> operators = formulas.getOperators();
        Queue<Double> operands = formulas.getOperands();
        double stackUpValue = operands.poll();

        while (!operators.isEmpty()) {
            Calculation calculation = Calculation.findByOperator(operators.poll());
            stackUpValue = calculation.calculate(stackUpValue, operands.poll());
        }
        return (int) stackUpValue;
    }

}
