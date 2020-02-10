package domain;

import utils.Exit;
import utils.InputValidation;
import view.InputView;
import view.OutputView;

import java.util.*;
import java.util.function.BiFunction;

public class Calculator {

    private final static int ZERO = 0;
    private final static int EVEN = 2;

    public void run() {
        splitFormula(InputView.inputFormula());
        OutputView.printResult(calculate(OperandRepository.getOperands(), OperatorRepository.getOperatorList()));
    }

    private void splitFormula(String formula) {
        String[] formulas = InputValidation.removeSpaceElement(formula.split(" ", ZERO));
        for (int i = ZERO; i < formulas.length; i++) {
            if (i % EVEN == ZERO) {
                OperandRepository.addOperand(InputValidation.checkIsNumber(formulas[i]));
                continue;
            }
            OperatorRepository.addOperator(Operator.getOperatorForChar(InputValidation.checkIsOperator(formulas[i])));
        }
    }

    private double calculate(List<Double> operands, List<Operator> operators) {
        int numberIndex = ZERO;
        double result = operands.get(ZERO);
        for (Operator operator : operators) {
            numberIndex++;
            result = operator.intermediateCalculation(result, operands.get(numberIndex));
        }
        return result;
    }
}
