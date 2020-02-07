package calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Calculator {

    Queue<String> operatorQueue = new LinkedList<>();
    Queue<Double> numberQueue = new LinkedList<>();

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run();
    }

    private void run() {
        String[] equations = getInputEquation();
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
            result = distinguishOperator(result, operator, nextNumber);
        }

        return result;
    }

    public double distinguishOperator(double prevNumber, String operator, double nextNumber) {
        double result = 0.0;

        if(operator.equals("+")) { result = prevNumber + nextNumber; }
        if(operator.equals("-")) { result = prevNumber - nextNumber; }
        if(operator.equals("*")) { result = prevNumber * nextNumber; }
        if(operator.equals("/")) { result = prevNumber / nextNumber; }

        return result;
    }


    private String[] getInputEquation() {
        Scanner scanner = new Scanner(System.in);
        String[] equations;

        while(true) {
            try {
                String equation = scanner.nextLine();
                equations = equation.split(" ");
                checkEquationElementValue(equations);
                break;
            } catch(NumberFormatException e) {
                System.out.println("다시 입력해주세요");
            }
        }

        return equations;
    }

    private void checkEquationElementValue(String[] equations) {
        checkOperatorValue(equations);
        checkNumberValue(equations);
    }

    private void checkOperatorValue(String[] equations) {
        for(int i=1; i<equations.length; i += 2) {
            if(isWrongOperator(equations, i)) { throw new NumberFormatException(); }
            if(isInvalidEquation(equations)) { throw new NumberFormatException(); }
            if(isDividedByZero(equations, i)) { throw new NumberFormatException(); }
        }
    }

    public boolean isWrongOperator(String[] equations, int index) {
        return !equations[index].equals("+") && !equations[index].equals("-") && !equations[index].equals("*") && !equations[index].equals("/");
    }

    public boolean isInvalidEquation(String[] equations) {
        return equations.length % 2 == 0;
    }

    public boolean isDividedByZero(String[] equations, int index) {
        return equations[index].equals("/") && Double.parseDouble(equations[index+1]) == 0.0;
    }

    public void checkNumberValue(String[] equations) {
        for(int i=0; i<equations.length; i += 2) {
            if(Double.parseDouble(equations[i]) > (double) Integer.MAX_VALUE
                    || Double.parseDouble(equations[i]) < -(double) Integer.MAX_VALUE) {
                throw new NumberFormatException();
            }
        }
    }
}
