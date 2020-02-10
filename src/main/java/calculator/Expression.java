package calculator;

import java.util.Arrays;
import java.util.List;

public class Expression {
    private final List<String> readOnlyElements;

    public Expression(String userInput) {
        String[] userInputArray = userInput.split(" ");

        if (isNotCorrectExpression(userInputArray)) {
            throw new IllegalArgumentException(
                    "※ 문자열 입력 규칙에 맞게 다시 입력해 주시기 바랍니다."
            );
        }

        readOnlyElements = Arrays.asList(userInputArray);
    }

    public List<String> getReadOnlyElements() {
        return readOnlyElements;
    }

    private boolean isNotCorrectExpression(String[] userInputArray) {
        return isNotNumberAtOddPosition(userInputArray) || isNotOperatorAtEvenPosition(userInputArray) || isNotNumberAtLastPosition(userInputArray);
    }

    private boolean isNotOperatorAtEvenPosition(String[] userInputArray) {
        for (int i = 1; i < userInputArray.length; i += 2) {
            String inputAtOddIndex = userInputArray[i];
            if (Operator.isNotOperator(inputAtOddIndex)) {
                return true;
            }
        }

        return false;
    }

    private boolean isNotNumberAtOddPosition(String[] userInputArray) {
        for (int i = 0; i < userInputArray.length; i += 2) {
            String inputAtEvenIndex = userInputArray[i];
            if (isNotNumber(inputAtEvenIndex)) {
                return true;
            }
        }

        return false;
    }

    private boolean isNotNumber(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return true;
        }

        return false;
    }

    private boolean isNotNumberAtLastPosition(String[] userInputArray) {
        int lastIndex = userInputArray.length - 1;
        String inputAtLastIndex = userInputArray[lastIndex];
        return isNotNumber(inputAtLastIndex);
    }

}
