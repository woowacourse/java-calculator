package application.calculator;

import application.input.InputEquation;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    private static final int NUMBER_POSITION = 2;
    private static final int NEXT_OPERATION_INDEX = 2;
    private static final int FIRST_OPERATOR_INDEX = 1;
    private static final int NEXT_INDEX = 1;
    private static final int INVALID_EQUATION_LENGTH = 0;
    private static final int CHECK_VALID_EQUATION_VALUE = 2;

    private static final double ZERO = 0.0;

    public void run() {
        InputEquation inputEquation = new InputEquation();
        String[] equations = inputEquation.getInputEquation();
        System.out.println(calculateEquation(equations));
    }

    public Double calculateEquation(String[] equation) {

        Queue<String> operatorQueue = new LinkedList<>();
        Queue<Double> numberQueue = new LinkedList<>();

        for(int i = 0; i < equation.length; i += NUMBER_POSITION) {
            numberQueue.add(Double.parseDouble(equation[i]));
        }

        for(int i = FIRST_OPERATOR_INDEX; i < equation.length; i += NEXT_OPERATION_INDEX) {
            operatorQueue.add(equation[i]);
        }

        return checkOperatorAndCalculate(operatorQueue, numberQueue);
    }

    private double checkOperatorAndCalculate(Queue<String> operatorQueue, Queue<Double> numberQueue) {
        double result = numberQueue.poll();
        int size = numberQueue.size();

        for(int i = 0; i < size; i++) {
            String operator = operatorQueue.poll();
            double nextNumber = numberQueue.poll();
            result = distinguishOperator(result, operator, nextNumber);
        }

        return result;
    }

    public double distinguishOperator(double prevNumber, String operator, double nextNumber) {
        if(PLUS.equals(operator)) {
            prevNumber += nextNumber;
        } else if(MINUS.equals(operator)) {
            prevNumber -= nextNumber;
        } else if(MULTIPLY.equals(operator)) {
            prevNumber *= nextNumber;
        } else if(DIVIDE.equals(operator)) {
            prevNumber /= nextNumber;
        }
        return prevNumber;
    }

    public void checkEquationElementValue(String[] equations) {
        checkOperatorValue(equations);
        checkNumberValue(equations);
    }

    private void checkOperatorValue(String[] equations) {
        for(int i=FIRST_OPERATOR_INDEX; i<equations.length; i += NEXT_OPERATION_INDEX) {
            if(isWrongOperator(equations, i)) {
                throw new NumberFormatException();
            }
            if(isInvalidEquation(equations)) {
                throw new NumberFormatException();
            }
            if(isDividedByZero(equations, i)) {
                throw new NumberFormatException();
            }
        }
    }

    public boolean isWrongOperator(String[] equations, int index) {
        return !equations[index].equals(PLUS) && !equations[index].equals(MINUS)
                && !equations[index].equals(MULTIPLY) && !equations[index].equals(DIVIDE);
    }

    public boolean isInvalidEquation(String[] equations) {
        return equations.length % CHECK_VALID_EQUATION_VALUE == INVALID_EQUATION_LENGTH;
    }

    public boolean isDividedByZero(String[] equations, int index) {
        return equations[index].equals(DIVIDE) && Double.parseDouble(equations[index+NEXT_INDEX]) == ZERO;
    }

    public void checkNumberValue(String[] equations) {
        for(int i=0; i<equations.length; i += NUMBER_POSITION) {
            if(isOverPositiveIntegerMaxValue(equations[i]) || isOverNegativeIntegerMaxValue(equations[i])) {
                throw new NumberFormatException();
            }
        }
    }

    private boolean isOverNegativeIntegerMaxValue(String equation) {
        return Double.parseDouble(equation) < -(double) Integer.MAX_VALUE;
    }

    private boolean isOverPositiveIntegerMaxValue(String equation) {
        return Double.parseDouble(equation) > (double) Integer.MAX_VALUE;
    }
}
