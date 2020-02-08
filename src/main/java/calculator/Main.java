package calculator;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("계산할 식을 입력해주세요.");
                String[] inputs = StringHandler.getInputAndSplit();
                Formula formula = new Formula(inputs);
                StringHandler.printResult(formula.calculateInputs());
                return;
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}

