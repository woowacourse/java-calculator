package calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Calculator {

    Queue<Integer> operatorQueue = new LinkedList<>();
    Queue<Integer> numberQueue = new LinkedList<>();

    private static final int CHECK_EVEN_NUMBER_MODULAR = 2;
    private static final int EVEN_NUMBER = 1;
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run();
    }

    private void run() {
        String[] equation = getEquation();

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

        }
    }
}
