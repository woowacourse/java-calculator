package calculator;

import io.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            CalculatorModel model = new CalculatorModel();
            model.run();
        } catch (Exception e) {
            OutputView.programError();
            OutputView.printWhichException(e);
            main(args);
        }
    }
}
