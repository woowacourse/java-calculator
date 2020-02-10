package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

    private Queue<String> operatorQueue;
    private Queue<Double> numberQueue;

    public Calculator() {
        this.operatorQueue = new LinkedList<>();
        this.numberQueue = new LinkedList<>();
    }

    public int divideEquationIntoOperandsOperator(String[] equation) {
        for(int i = 0; i < equation.length; i += 2) {
            numberQueue.add(Double.parseDouble(equation[i]));
        }

        for(int i = 1; i < equation.length; i += 2) {
            operatorQueue.add(equation[i]);
        }
        return operatorQueue.size();
    }

    public double checkOperatorAndCalculate(int queueSize) {
        double result = numberQueue.poll();
        for(int i = 0; i < queueSize; i++) {
            String currentOperator = operatorQueue.poll();
            double currentOperand = numberQueue.poll();
            result = calculateEquation(result, currentOperator, currentOperand);
        }
        return result;
    }

    public double calculateEquation(double result, String operator, double operand) {
        Operator currentOperator = Operator.createOperatorByString(operator);
        return currentOperator.calculate(result, operand);
    }


}
