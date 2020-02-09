package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    private Operator op = new Operator();
    private UserInput input = new UserInput();
    private Queue<String> operatorQueue = new LinkedList<>();
    private Queue<Double> numberQueue = new LinkedList<>();

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run();
    }

    private void run() {
        String[] equations = input.getInputEquation();
        System.out.println(calculateEquation(equations));
    }

    public Double calculateEquation(String[] equation) {
        for(int i = 0; i < equation.length; i += 2) {
            numberQueue.add(Double.parseDouble(equation[i]));
        }

        for(int i = 1; i < equation.length; i += 2) {
            operatorQueue.add(equation[i]);
        }

        return checkOperatorAndCalculate();
    }

    private double checkOperatorAndCalculate() {
        double result = numberQueue.poll();
        int size = numberQueue.size();

        for(int i = 0; i < size; i++) {
            String operator = operatorQueue.poll();
            double nextNumber = numberQueue.poll();
            result = op.operate(operator, result, nextNumber);
        }

        return result;
    }
}
