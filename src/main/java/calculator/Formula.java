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
        Operand operand1 = formula.poll().getOperand();
        double result = operand1.getOperand();

        while (formula.size() > 0) {
            Operator operator = formula.poll().getOperator();
            Operand operand2 = formula.poll().getOperand();
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
