package calculator;

import java.util.ArrayList;
import java.util.List;

public class Source {
    private List<Double> operands;
    private List<String> operators;
    private boolean operandTurn;

    public Source(String[] inputs) {
        operands = new ArrayList<>();
        operators = new ArrayList<>();
        operandTurn = true;
        generateSource(inputs);
    }

    public void generateSource(String[] inputs) {
    }
}
