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
        String[] equations = getEquation();
        System.out.println(calculateEquation(equations));
    }

    private Double calculateEquation(String[] equation) {
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
            double nextNum = numberQueue.poll();
            result = distinguishOperator(result, operator, nextNum);
        }

        return result;
    }

    private double distinguishOperator(double prevNumber, String operator, double nextNumber) {
        double result = 0.0;

        if(operator.equals("+")) { result = prevNumber + nextNumber; }
        if(operator.equals("-")) { result = prevNumber - nextNumber; }
        if(operator.equals("*")) { result = prevNumber * nextNumber; }
        if(operator.equals("/")) { result = prevNumber / nextNumber; }

        return result;
    }


    private String[] getEquation() {
        Scanner scanner = new Scanner(System.in);
        String[] equations;

        while(true) {
            try {
                String equation = scanner.nextLine();
                equations = equation.split(" ");
                checkNumber(equations);
                checkOperator(equations);
                break;
            } catch(NumberFormatException e) {
                e.getMessage();
                System.out.println("다시 입력해주세요");
            }
        }

        return equations;
    }

    private void checkNumber(String[] equations) {
        for(int i=0; i<equations.length; i += 2) {
            if(Double.parseDouble(equations[i]) > (double) Integer.MAX_VALUE
                    || Double.parseDouble(equations[i]) < -(double) Integer.MAX_VALUE) {
                throw new NumberFormatException();
            }
        }
    }

    private void checkOperator(String[] equations) {
        for(int i=1; i<equations.length; i += 2) {
            if(!equations[i].equals("+") && !equations[i].equals("-") && !equations[i].equals("*") && !equations[i].equals("/")) {
                throw new NumberFormatException();
            }
            if(equations.length % 2 == 0) {
                throw new NumberFormatException();
            }
            if(equations[i].equals("/") && Double.parseDouble(equations[i+1]) == 0.0) {
                throw new NumberFormatException();
            }
        }
    }
}
