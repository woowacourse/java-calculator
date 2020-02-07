package view;

public class OutputView {
    public static void printInputCalculationMessage() {
        System.out.println("계산식을 입력해주세요.");
        System.out.println("입력된 계산식은 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정됩니다.");
    }

    public static void printCalculate(double result) {
        System.out.println(result);
    }
}
