import calculator.Formula;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        try {
            String[] inputs = InputView.getInputAndSplit();
            Formula formula = new Formula(inputs);
            OutputView.printResult(formula.calculateFormula());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}

