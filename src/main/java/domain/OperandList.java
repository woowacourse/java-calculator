package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OperandList {
    private final static List<Double> operands = new ArrayList<>();

    public static void addOperand(double operand) {
        operands.add(operand);
    }

    public static List<Double> getOperands() {
        return Collections.unmodifiableList(operands);
    }
}
