import domain.Calculator;
import domain.Formulas;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        calculate();
    }

    private static void calculate() {
        try {
            OutputView.output(calculate2());
        } catch (Exception e) {
            OutputView.exceptionMessage(e.getMessage());
            calculate();
        }
    }

    private static double calculate2() {
        Formulas formulas = new Formulas(InputView.input());
        double result = Double.parseDouble(formulas.get(0));
        for (int index = 1; index < formulas.size(); index += 2) {
            result = Calculator.calculate(formulas.get(index), result, formulas.get(index + 1));
        }
        return result;
    }
}
