package calculator;

import java.util.*;

/**
 * Calculator 클래스는 계산기의 기능을 수행하는 클래스로,
 * 입력, 데이터 검증, 사칙연산 수행, 결과값 출력을 메서드로 가진다.
 */

public class Calculator {
    /**
     * final static String 형식으로 plus, minus, multiply, divide를 선언하였다.
     * 직접 상수값을 코드에 기재하지 않기 때문에 수정이 용이할 것이다.
     * 그러나, 연산 메서드 자체까지 대체하고 더 높은 안정성을 가지도록 enum으로 대체가 가능하리라 생각된다.
     * 시간이 난다면 꼭 수정해야 할 부분이다.
     */
    private final static String PLUS = "+";
    private final static String MINUS = "-";
    private final static String MULTIPLY = "*";
    private final static String DIVIDE = "/";

    /**
     * Calculator는 생성자 메서드이다. 수행하는 작업은 없다.
     */
    public Calculator() {
    }

    /**
     * start 메서드는 계산기의 메인 동작을 수행한다.
     * 올바르지 않은 입력이 들어오면 입력을 다시 요청하고,
     * 올바른 값이 들어오면 값을 출력해준다.
     * 이 때 while을 통한 루프 구조 대신,
     * 자기 자신을 재귀적으로 호출하여 올바른 값이 나올 까지 실행하도록 설계하였다.
     *
     * @throws ArithmeticException    : 만약 0으로 나누기 오류가 발생하면 예외처리한다
     * @throws NumberFormatException  : 만약 입력받은 숫자가 유효하지 않은 값이라면 예외처리한다
     * @throws InputMismatchException : 만약 입력받은 수식 값이 유효하지 않은 값이라면 예외처한다
     */
    public void start() {
        System.out.println("\n계산할 수식을 입력해주세요. (숫자와 연산자는 공백으로 구분)");
        String inputString = inputEquation();
        if (validateString(inputString)) {
            System.out.println("빈 문자열입니다. 다시 입력해주세요.");
            start();
        }
        Queue<String> equation = makeQueue(inputString);
        try {
            System.out.println(execute(equation));
        } catch (ArithmeticException e1) {
            System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
            start();
        } catch (NumberFormatException e2) {
            System.out.println("잘못된 수식이 입력되었습니다. 다시 입력해주세요.");
            start();
        } catch (InputMismatchException e3) {
            System.out.println("잘못된 수식이 입력되었습니다. 다시 입력해주세요.");
            start();
        }
    }

    /**
     * inputEquation은 수식을 입력받고 값을 리턴해준다.
     *
     * @return 입력받은 문자열 값을 반환한다.
     */
    private String inputEquation() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * validateString은 입력받은 문자열 값이 비어있는지(즉, 유효하지 않은 문자열인지) 확인하는 메서드이다.
     *
     * @param inputString 입력받은 문자열을 파라미터로 전달한다.
     * @return 만약 문자열이 올바르지 않다면 true를, 올바르다면 false를 반환한다.
     */
    public boolean validateString(String inputString) {
        return inputString == null || inputString.equals("");
    }

    /**
     * makeQueue는 입력받은 문자열을 공백 기준으로 자르고,
     * 그 값을 큐에 넣어 반환해주는 메서드이다.
     *
     * @param inputString 입력받은 문자열을 파라미터로 전달한다.
     * @return 입력받은 값을 문자열 큐에 넣어 반환한다.
     */
    public Queue<String> makeQueue(String inputString) {
        String[] elements = inputString.split("\\s+", 0);
        return new LinkedList<>(Arrays.asList(elements));
    }

    /**
     * execute는 실제 메인 로직(각각의 숫자, 연산자를 큐에서 뽑아내어 계산하는 것)을 수행하는 메서드이다.
     * 수행 과정에서 다양한 오류에 대응하여 예외처리를 throw 한다.
     * 큐가 빌 경우 연산을 끝내고 지금까지 누적된 정수형 연산값을 반환해준다.
     *
     * @param equation 수식이 저장되어 있는 문자열 큐를 전달한다.
     * @return 계산이 끝난 정수형 결과값을 반환한다.
     * @throws ArithmeticException    만약 연산 과정에서 0으로 나누기 에러가 발생 시 throw한다.
     * @throws NumberFormatException  만약 연산 과정에서 올바르지 않은 숫자값이 발견될 시 throw한다.
     * @throws InputMismatchException 만약 연산 과정에서 올바르지 않은 문자열(연산자) 값이 발견될 시 throw한다.
     */
    public int execute(Queue<String> equation) throws ArithmeticException, NumberFormatException, InputMismatchException {
        int result = validateNumber(equation.poll());
        while (!equation.isEmpty()) {
            String operator = equation.poll();
            int operand = validateNumber(equation.poll());
            result = calculate(result, operator, operand);
        }
        return result;
    }

    /**
     * validateNumber는 숫자값이 유효한지 검사하는 메서드이다.
     * 값을 변환하면서 만약 예외 발생시 이를 throw한다.
     *
     * @param number 검사할 String형 숫자를 파라미터로 전달받는다.
     * @return 예외 미발생시 숫자값을 정수형으로 변환하여 반환한다.
     * @throws NumberFormatException 만약 값이 유효하지 않은 숫자값(오버플로우, 숫자가 아닌 문자열 등)일 경우 throw한다.
     */
    public int validateNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    /**
     * calculate는 두 개의 정수 값과 연산자 값을 입력받고,
     * 연산자 값에 따라 정해진 연산을 두 숫자에 수행하여 결과값을 반환한다.
     * 만약 enum을 통해 PLUS,MINUS 등의 메서드가 등록되어 있다면 switch가 없어도 될듯하다.
     * 이에 대해서는 추후 수정할 예정이다. (문서 주석 20.02.07 작성)
     *
     * @param result   이전에 계산해 둔 정수형 값을 전달받는다.
     * @param operator 새로 수행할 문자열 연산을 전달받는다.
     * @param operand  새로 연산을 수행할 정수형 숫자를 전달받는다.
     * @return 연산에 따른 정수형 결과값을 반환한다.
     * @throws InputMismatchException 만약 연산자 문자열이 사칙연산자 이외의 값이라면 예외를 발생시킨다.
     * @throws ArithmeticException    만약 0으로 나누는 연산 발생 시 예외를 throw한다.
     */
    public int calculate(int result, String operator, int operand) throws ArithmeticException {
        switch (operator) {
            case PLUS:
                return add(result, operand);
            case MINUS:
                return subtract(result, operand);
            case MULTIPLY:
                return multiply(result, operand);
            case DIVIDE:
                return divide(result, operand);
            default:
                throw new InputMismatchException("해당 연산자 없음");
        }
    }

    /**
     * add는 입력받은 두 정수형 값을 더하여 반환한다.
     *
     * @param a 계산을 수행할 정수형 숫자이다.
     * @param b 계산을 수행할 정수형 숫자이다.
     * @return 계산된 값을 반환한다.
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * add는 입력받은 첫번째 정수값에서 두번째 정수값을 뺀 뒤 그 값을 반환한다.
     *
     * @param a 계산을 수행할 정수형 숫자이다.
     * @param b 계산을 수행할 정수형 숫자이다.
     * @return 계산된 값을 반환한다.
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * add는 입력받은 두 정수형 값을 하여 반환한다.
     *
     * @param a 계산을 수행할 정수형 숫자이다.
     * @param b 계산을 수행할 정수형 숫자이다.
     * @return 계산된 값을 반환한다.
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * divide는 입력받은 첫번째 값을 입력받은 두번째 값으로 나눠 그 값을 반환한다.
     *
     * @param a 계산을 수행할 정수형 숫자이다.
     * @param b 계산을 수행할 정수형 숫자이다.
     * @return 계산된 값을 반환한다.
     */
    public int divide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            throw e;
        }
    }
}
