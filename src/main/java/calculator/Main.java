package calculator;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                calculate();
                return;
            } catch (Exception e) {
                System.out.println("입력값이 잘못되었습니다.");
                e.printStackTrace();
                continue;
            }
        }
    }

    private static void calculate() throws Exception {
        System.out.println("계산할 식을 입력해주세요.");
        String input = InputView.getInput();
        String[] inputs = InputHandler.splitInput(input);

        Expression expression = new Expression(inputs);
        OutputView.printResult(expression.calculateInputs());
    }
}

