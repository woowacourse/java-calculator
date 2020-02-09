package calculator;

import io.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            OutputView.welcome();
            CalculatorController model = new CalculatorController();
            model.runCalculator();
        } catch (Exception e) {
            OutputView.inputError();
            Application.main(args);
        }
    }
}
