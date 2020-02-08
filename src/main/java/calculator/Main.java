package calculator;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("계산할 식을 입력해주세요.");
                String input = InputView.getInput();
                String[] inputs = InputHandler.splitInput(input);
                SourceForCalculating sourceForCalculating = new SourceForCalculating(inputs);
                sourceForCalculating.printResult(sourceForCalculating.calculateInputs());
                return;
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}

