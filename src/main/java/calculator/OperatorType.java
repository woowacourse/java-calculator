package calculator;

/**
 * OperatorType 클래스는 계산기에서 사용되는 사칙연산을 모아놓은 Enum이다.
 * 각각의 사칙연산 문자열에 대하여 매칭되는 원소를 찾고,
 * 그 원소에 포함되어있는 메서드(OperationMethod 인터페이스를 바탕으로 만든)를 사용한다.
 */

public enum OperatorType {
    PLUS("+", (a, b) -> (a + b)),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    /**
     * operator는 연산자의 문자열 값이다. 이를 바탕으로 연산자 문자열과 실제 연산 메서드를 매칭한다.
     */
    private final String operator;
    /**
     * operationMethod는 각각의 연산이 실제 수행될 때 가지는 메서드가 저장되는 인터페이스이다.
     */
    private final OperationMethod operationMethod;

    /**
     * OperatorType 생성자에서는 두 개의 파라미터를 입력받아 이를 필드값에 대입한다.
     *
     * @param operator        String형의 연산자 문자열이다.
     * @param operationMethod 연산자 호출 시 수행되는 메서드이다.
     */
    OperatorType(String operator, OperationMethod operationMethod) {
        this.operator = operator;
        this.operationMethod = operationMethod;
    }

    /**
     * operate는 static으로 선언된 메서드로, 호출시 두 정수값과 연산자 값을 받아 계산을 수행한다.
     * 이때, 연산자 값을 바탕으로 findApplyToOperator를 호출해 적절한 Enum원소를 찾고 그 요소에 포함되는 메서드를 실행한다.
     *
     * @param n1            연산에 쓰일 첫번째 정수 값이다.
     * @param inputOperator 두 정수값 파라미터에 대해 수행될, String으로 된 연산자이다.
     * @param n2            연산에 쓰일 두번째 정수 값이다.
     * @return 연산이 완료된 값을 정수형으로 반환한다.
     * @throws IllegalArgumentException : 만약 OperatorType 내에 존재하지 않는 연산자(inputOperator)가 들어오면 예외를 발생시킨다.
     */
    public static int operate(int n1, String inputOperator, int n2) throws IllegalArgumentException {
        return findApplyToOperator(inputOperator).operationMethod.apply(n1, n2);
    }

    /**
     * findApplyToOperator는 연산자 문자열 값을 입력받아, 이에 맞는 Enum(OperatorType) 요소를 찾아 반환해준다.
     * 만약 OperatorType 요소 전체를 순회하였는데도 매칭되는 값이 없다면, 예외를 throw한다.
     *
     * @param inputOperator 검색을 위한 String형의 연산자 문자열이다.
     * @return inputOperator를 operator 요소로 가지는 OperatorType 객체를 반환한다.
     * @throws IllegalArgumentException : 만약 OperatorType 요소 전체에서 inputOperator와 같은 값을 찾지 못하면, 예외를 발생시킨다.
     */
    public static OperatorType findApplyToOperator(String inputOperator) throws IllegalArgumentException {
        for (OperatorType calculatorType : OperatorType.values()) {
            if (calculatorType.toString().equals(inputOperator)) {
                return calculatorType;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * toString은 Override된 메서드로, 객체의 operator값을 반환한다.
     *
     * @return 연산자 문자열 값인 operator 값읇 반환한다.
     */
    @Override
    public String toString() {
        return operator;
    }
}

/**
 * OperationMethod는 위의 OperatorType에서 사용될 사칙연산 메서드의 원형만을 가지는 인터페이스이다.
 * 이를 바탕으로 각각의 연산이 자신만의 메서드 로직을 수정한다.
 * 오해가 없도록 FunctionalInterface 에노테이션을 추가하였다.
 */
@FunctionalInterface
interface OperationMethod {
    int apply(int n1, int n2);
}
