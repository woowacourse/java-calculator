package calculator;

import java.util.ArrayList;
import java.util.List;

public class Formula {
    private List<FormulaElement> formula;

    private static final int FIRST_ELEMENT = 0;
    private static final int SECOND_ELEMENT = 1;

    public Formula(String[] inputs) {
        validateSizeOfInputsIsOdds(inputs);
        formula = new ArrayList<>();
        generateFormula(inputs);
    }

    public double calculateFormula() {
        Operand result = formula.get(FIRST_ELEMENT).getOperand();

        for (int i = SECOND_ELEMENT; i < formula.size(); i++) {
            Operator operator = formula.get(i).getOperator();
            Operand operand = formula.get(i).getOperand();
            result = new Operand(operator.calculate(result, operand));
        }
        return result.getOperandValue();
    }

    private void generateFormula(String[] inputs) {
        for (String input : inputs) {
            formula.add(generateFormulaElement(input));
        }
    }

    private FormulaElement generateFormulaElement(String input) {
        if (isOperandTurn()) {
            Operand operand = new Operand(input);
            return new FormulaElement(operand);
        }
        Operator operator = new Operator(input);
        return new FormulaElement(operator);
    }

    private boolean isOperandTurn() {
        return isEvenNumber(formula.size());
    }

    private void validateSizeOfInputsIsOdds(String[] inputs) {
        if (isEvenNumber(inputs.length)) {
            throw new IllegalArgumentException(inputs.length + "(length of inputs) is not odd");
        }
    }

    private boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}

class FormulaElement {
    private Operand operand;
    private Operator operator;

    FormulaElement(Operand operand) {
        this.operand = operand;
    }

    FormulaElement(Operator operator) {
        this.operator = operator;
    }

    public Operand getOperand() {
        return operand;
    }

    public Operator getOperator() {
        return operator;
    }
}
