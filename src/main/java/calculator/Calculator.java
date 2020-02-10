package calculator;

import domain.Numbers;
import domain.OperatorGroup;
import java.util.List;

public class Calculator {
    private final static int FIRST_RESULT = 0;

    public static double calculate(Numbers numbers, List<OperatorGroup> operators) {
        double result = Double.parseDouble(numbers.get(FIRST_RESULT));

        for (int operatorIndex = FIRST_RESULT, numberIndex = 1; operatorIndex < operators.size() ; operatorIndex++, numberIndex++) {
            OperatorGroup newOperator = operators.get(operatorIndex);
            Double newNumber = Double.parseDouble(numbers.get(numberIndex));
            result = newOperator.apply(result, newNumber);
        }
        return result;
    }
}
