package domain;

import java.util.Queue;

public class Calculator {
    public static int calculateByFormulas(Formulas formulas) {
        Queue<String> operators = formulas.getOperators();
        Queue<Double> operands = formulas.getOperands();
        double accumulationValue = operands.poll();

        while (!operators.isEmpty()) {
            Calculation calculation = Calculation.findByOperator(operators.poll());
            accumulationValue = calculation.calculate(accumulationValue, operands.poll());
        }
        return (int) accumulationValue;
    }

}
