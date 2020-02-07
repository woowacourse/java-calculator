import domain.Calculator;
import domain.Formulas;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        int result = calculateByInput();
        OutputView.printResult(result);
    }

    private static int calculateByInput() {
        try {
            Formulas formulas = new Formulas(InputView.input());
            Calculator calculator = new Calculator(formulas);
            return calculator.stringCalculate();
        } catch (IllegalArgumentException e) {
            OutputView.exceptionMessage(e.getMessage());
            return calculateByInput();
        }
    }
}
