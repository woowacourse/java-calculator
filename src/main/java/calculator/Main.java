package calculator;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                String[] inputs = StringHandler.getInputAndSplit();
                Formula formula = new Formula(inputs);
                StringHandler.printResult(formula.calculateFormula());
                return;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}

