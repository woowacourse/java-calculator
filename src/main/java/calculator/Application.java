package calculator;

public class Application {
    public static void main(String[] args) {
        try {
            CalculatorModel model = new CalculatorModel();
            model.runCalculator();
        } catch (Exception e) {
            System.out.println("문제가 생겼으니 담당자에게 전화 부탁드립니다.");
        }
    }
}
