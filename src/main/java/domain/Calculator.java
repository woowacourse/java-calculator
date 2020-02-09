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
    private final BiFunction<Double, Double, Double> ADDITION = (a, b) -> a + b;
    private final BiFunction<Double, Double, Double> SUBTRACTION = (a, b) -> a - b;
    private final BiFunction<Double, Double, Double> MULTIPLICATION = (a, b) -> a * b;
    private final BiFunction<Double, Double, Double> DIVISION = (a, b) -> {
        if (b == ZERO) Exit.sendErrorMessage("0으로는 나눌 수 없습니다.");
        return a / b;
    };
    private final Map<Operator, BiFunction<Double, Double, Double>> calculateFunctionMap = new HashMap<>();

    public Calculator() {
        calculateFunctionMap.put(Operator.PLUS, ADDITION);
        calculateFunctionMap.put(Operator.MINUS, SUBTRACTION);
        calculateFunctionMap.put(Operator.MULTIPLY, MULTIPLICATION);
        calculateFunctionMap.put(Operator.DIVISION, DIVISION);
    }

    public void run() {
        splitFormula(InputView.inputFormula());
        OutputView.printResult(calculate(OperandRepository.getOperands(), OperatorRepository.getOperatorList()));
    }

    private void splitFormula(String formula) {
        String[] formulas = InputValidation.trimSpace(formula.split(" ", ZERO));
        for (int i = ZERO; i < formulas.length; i++) {
            String temp = formulas[i];
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
            result = calculateFunctionMap
                    .get(operator)
                    .apply(result, operands.get(numberIndex));
        }
        return result;
    }
}
