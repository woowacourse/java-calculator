package calculator;

import java.util.Scanner;

public class Calculator {
    private static final int INITIAL_VALUE = 0;
    private static final int CHECK_EVEN_NUMBER_MODULAR = 2;
    private static final int EVEN_NUMBER = 1;
    public void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run();
    }

    private void run() {
        String[] equation = getEquation();
        calculateEquation(equation);
    }

    private void calculateEquation(String[] equation) {
        int result = Integer.parseInt(equation[0]);
        for(int i=0; i<equation.length; i++) {
            if(i%CHECK_EVEN_NUMBER_MODULAR == EVEN_NUMBER) {
                result = checkOperatorAndCalculate(result, equation[i], Integer.parseInt(equation[i+1]));
            }
        }
    }

    private int checkOperatorAndCalculate(int previous, String operator, int next) {
        if(operator.equals("+")) { return previous + next; }
        if(operator.equals("-")) { return previous - next; }
        if(operator.equals("*")) { return previous * next; }
        if(operator.equals("/")) { return previous / next; }
        return -1;
    }


    private String[] getEquation() {
        Scanner scanner = new Scanner(System.in);
        String equation = scanner.nextLine();
        return equation.split(" " );
    }

}
