package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Formulas {
    private static final int OPERATOR_INDEX_VALUE = 2;
    private static final int OPERAND_INDEX_VALUE = 2;

    private final List<String> formulas;

    public Formulas(Formula formula) {
        this.formulas = formula.toList();
    }

    public Queue<String> getOperators() {
        Queue<String> operators = new LinkedList<>();
        for (int index = 1; index < formulas.size(); index += OPERATOR_INDEX_VALUE) {
            operators.add(formulas.get(index));
        }
        return operators;
    }

    public Queue<Double> getOperands() {
        Queue<Double> operands = new LinkedList<>();
        for (int index = 0; index < formulas.size(); index += OPERAND_INDEX_VALUE) {
            operands.add(Double.parseDouble(formulas.get(index)));
        }
        return operands;
    }
}
