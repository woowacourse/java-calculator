package domain;

import utils.InputValidation;
import utils.ValueValidation;
import view.InputView;
import view.OutputView;

import java.util.*;

public class Calculator {
    public void run() {
        splitFormula(InputView.inputFormula());
        OutputView.printResult(calculate(OperandList.getOperands(), OperatorList.getOperatorList()));
    }

    private void splitFormula(String formula) {
        String[] formulas = InputValidation.removeSpaceElement(formula.split(" "));
        for (int i = 0; i < formulas.length; i++) {
            divideOddAndEven(formulas[i], i);
        }
    }

    private void divideOddAndEven(String formula, int index) {
        if (ValueValidation.isZeroOrEven(index) && InputValidation.isNumber(formula)) {
            OperandList.addOperand(Double.parseDouble(formula));
            return;
        }
        if (ValueValidation.isOdd(index) && InputValidation.isOperator(formula)) {
            OperatorList.addOperator(Operator.getOperatorForString(formula));
            return;
        }
        throw new IllegalArgumentException("잘못된 수식을 입력했습니다.");
    }

    private double calculate(List<Double> operands, List<Operator> operators) {
        int numberIndex = 0;
        double result = operands.get(0);
        for (Operator operator : operators) {
            numberIndex++;
            result = operator.intermediateCalculation(result, operands.get(numberIndex));
        }
        return result;
    }
}
