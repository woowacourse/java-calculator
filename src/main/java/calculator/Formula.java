package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Formula {
    private Queue<FormulaElement> formula;

    public Formula(String[] inputs) {
        validateSizeOfInputsIsOdds(inputs);
        formula = new LinkedList<>();
        generateFormula(inputs);
    }

    public double calculateFormula() {
        Operand operand1 = (Operand) formula.poll();
        double result = operand1.getOperand();

        while (formula.size() > 0) {
            Operator operator = (Operator) formula.poll();
            Operand operand2 = (Operand) formula.poll();
            result = operator.calculate(operand1, operand2);
            operand1 = new Operand(result);
        }
        return result;
    }

    private void generateFormula(String[] inputs) {
        for (String input : inputs) {
            formula.offer(generateFormulaElement(input));
        }
    }

    private FormulaElement generateFormulaElement(String input) {
        if (isOperandTurn()) {
            return new Operand(input);
        }
        return new Operator(input);
    }

    private boolean isOperandTurn() {
        return !isOddNumber(formula.size());
    }

    private void validateSizeOfInputsIsOdds(String[] inputs) {
        if (!isOddNumber(inputs.length)) {
            throw new IllegalArgumentException(inputs.length + "(length of inputs) is not odd");
        }
    }

    private boolean isOddNumber(int number) {
        return number % 2 == 1;
    }
}

class FormulaElement {
}
