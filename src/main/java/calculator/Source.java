package calculator;

import java.util.ArrayList;
import java.util.List;

public class Source {
    private List<Double> operands;
    private List<String> operators;
    private boolean operandTurn;

    public Source(String[] inputs) throws Exception {
        operands = new ArrayList<>();
        operators = new ArrayList<>();
        operandTurn = true;
        generateSource(inputs);
    }

    public void generateSource(String[] inputs) throws Exception {
        validateSizeOfInputsIsOdds(inputs);
    }

    private void validateSizeOfInputsIsOdds(String[] inputs) throws Exception {
        if (isOddNumber(inputs.length)) {
            throw new Exception("inputs의 사이즈가 홀수가 아님");
        }
    }

    private boolean isOddNumber(int number) {
        return number % 2 == 1;
    }
}
