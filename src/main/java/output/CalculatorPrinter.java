package output;

import calculator.expression.InvalidMathematicalExpressionException;
import calculator.expression.MathematicalExpression;

public class CalculatorPrinter {

    private static final String RESULT_FORMATTED_STRING = "결과: %f";

    public static void printIntroduction() {
        System.out.println("계산기를 실행해주셔서 감사합니다.");
        System.out.println("계산기 프로그램은 공백을 기준으로 숫자와 연산자를 구분합니다.");
        System.out.println("수식을 입력하시면 입력된 수식을 기준으로 계산 결과를 출력합니다.");
        System.out.println("저희 계산기는 연산자의 우선순위 없이 순서대로 계산되니 정확한 연산에는 사용을 피해주세요");
        System.out.println();
    }

    public static void printExpression(MathematicalExpression expression) {
        System.out.println(String.format(RESULT_FORMATTED_STRING, expression.getResult()));
        System.out.println();
    }

    public static void printException(InvalidMathematicalExpressionException iee) {
        System.out.println();
        System.out.println("!!!!!!!!!!!!!!!!!경고!!!!!!!!!!!!!!!");
        System.out.println(iee.getMessage());
        System.out.println();
    }

}
