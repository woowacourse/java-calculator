package calculate;

import java.util.Scanner;
/*
    자료구조 수정
    enum 안쓰는걸로
    testcode 작성
* */

public class Calculate {

    private static final int CHECK_EVEN_NUMBER_MODULAR = 2;
    private static final int EVEN_NUMBER = 1;

    public static void main(String[] args) {
        Calculate calculator = new Calculate();
        calculator.run();
    }

    public void run() {
        System.out.println(getEquation());
    }

    public double calculateEquation(String[] equation) {
        Double result = Double.parseDouble(equation[0]);

        for(int i=0; i<equation.length-1; i++) {
            if(i % CHECK_EVEN_NUMBER_MODULAR == EVEN_NUMBER) {
                result = checkOperatorAndCalculate(result, equation[i], Double.parseDouble(equation[i+1]));
            }
        }

        return result;
    }

    public Double checkOperatorAndCalculate(Double previous, String operator, Double next) {
        double result = 0.0;
        if(operator.equals("+")) { result = previous + next; } // sum method 만들어야 할까
        if(operator.equals("-")) { result = previous - next; } // enum method 를 만들어야 할까?
        if(operator.equals("*")) { result = previous * next; }
        if(operator.equals("/") && next == 0) { throw new NumberFormatException("다시 입력해주세요"); }
        if(operator.equals("/") && next != 0) { result = previous / next; }
        return result;
    }

    public double getEquation() {
        double result;
        while(true) {
            try{
                result = calculateEquation(checkEquationNumbers());
                break;
            } catch(NumberFormatException e) {
                System.out.println("올바른 번호를 입력해주시기 바랍니다.");
            }
        }
        return result;
    }

    public String[] checkEquationNumbers() {
        Scanner scanner = new Scanner(System.in);
        String equation = scanner.nextLine();
        String[] equations = equation.split(" ");

        for(int i = 0; i < equations.length; i += 2) {
            if(Double.parseDouble(equations[i]) < -Double.MAX_VALUE || Double.parseDouble(equations[i]) > Double.MAX_VALUE) {
                throw new NumberFormatException("올바른 숫자를 입력해주세요");
            }
        }

        return equations;
    }
}


