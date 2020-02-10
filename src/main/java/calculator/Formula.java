package calculator;

import exceptions.NotOddLengthInputsException;

import java.util.LinkedList;
import java.util.Queue;

public class Formula {
    private Queue<Operand> operands;
    private Queue<Operator> operators;

    public Formula(String[] inputs) {
        validateSizeOfInputsIsOdds(inputs);
        operands = new LinkedList<>();
        operators = new LinkedList<>();
        generateFormula(inputs);
    }

    public int size() {
        return operands.size() + operators.size();
    }

    public Operand getOperand() {
        return operands.poll();
    }

    public Operator getOperator() {
        return operators.poll();
    }

    private void generateFormula(String[] inputs) {
        for (String input : inputs) {
            generateFormulaElement(input);
        }
    }

    private void generateFormulaElement(String input) {
        if (isOperandTurn()) {
            operands.offer(new Operand(input));
            return;
        }
        operators.offer(new Operator(input));
    }

    private boolean isOperandTurn() {
        return isEvenNumber(size());
    }

    private void validateSizeOfInputsIsOdds(String[] inputs) {
        if (isEvenNumber(inputs.length)) {
            throw new NotOddLengthInputsException(inputs.length);
        }
    }

    private boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}
