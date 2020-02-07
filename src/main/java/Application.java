import domain.Calculator;
import domain.Formulas;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        startCalculate();
    }

    private static void startCalculate() {
        try {
            OutputView.printResult(calculate());
        } catch (IllegalArgumentException e) {
            OutputView.exceptionMessage(e.getMessage());
            startCalculate();
        }
    }

    private static int calculate() {
        Formulas formulas = new Formulas(InputView.input());
        double result = checkNumbers(formulas.get(0));
        for (int index = 1; index < formulas.size(); index += 2) {
            result = Calculator.calculate(checkOperator(formulas.get(index)),
                    result, checkNumbers(formulas.get(index + 1)));
        }
        return (int) result;
    }

    private static double checkNumbers(String number) {
        if (!number.matches("^[0-9\\+\\-]?[0-9]+$")) {
            throw new IllegalArgumentException("잘못된 계산식 - 피연산자가 숫자가 아님 : " + number);
        }
        if (Long.parseLong(number) > Integer.MAX_VALUE || Long.parseLong(number) < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("잘못된 계산식 - 피연산자가 INT 범위를 벗어남 : " + number);
        }
        return Double.parseDouble(number);
    }

    private static String checkOperator(String operator) {
        if (operator.matches("^[\\+\\-\\*\\/]$")) {
            return operator;
        }
        throw new IllegalArgumentException("잘못된 계산식 - 연산자가 잘못됨 : " + operator);
    }
}
