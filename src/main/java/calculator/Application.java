package calculator;

import io.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            CalculatorModel model = new CalculatorModel();
            model.runCalculator();
        } catch (Exception e) {
            OutputView.programError();
        }
    }
}
