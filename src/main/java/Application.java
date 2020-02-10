import domain.Calculator;
import domain.Formula;
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
            Formula formula = new Formula(InputView.input());
            Formulas formulas = new Formulas(formula);
            return Calculator.calculateByFormulas(formulas);
        } catch (IllegalArgumentException e) {
            OutputView.exceptionMessage(e.getMessage());
            return calculateByInput();
        }
    }
}
