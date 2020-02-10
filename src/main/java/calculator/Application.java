package calculator;

import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Application {
    private static final String BLANK = " ";
    private static final int START_INDEX = 0;
    private static final int MAXIMUM_ERROR = 5;
    private static int errorCount = 0;

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        boolean isContinue = true;

        while (isContinue) {
            List<String> splittedStrings = repeatRequestingCorrectMathematicalExpression();
            Double answer = calculator.calculate(splittedStrings);
            OutputView.printAnswer(answer);
            isContinue = InputView.enterYesNo();
        }
    }

    //입력받고 나누고 올바른 식인지 확인. 올바른 식이 아니면 계속 반복
    private static List<String> repeatRequestingCorrectMathematicalExpression() {
        try {
            String input = InputView.enterMathematicalExpression();
            List<String> splittedStrings = Arrays.asList(input.split(BLANK));
            checkClusteredElements(splittedStrings);
            checkIfStartWithSymbol(splittedStrings);
            checkIsNumberOfListOdd(splittedStrings);
            errorCount = 0;
            return splittedStrings;
        } catch (IllegalArgumentException e) {
            errorCount++;
            exitProgramIfDoNotInputCorrectExpressionFiveTimes();
            OutputView.printErrorMessageAndErrorCount(e.getMessage(),errorCount);
            return repeatRequestingCorrectMathematicalExpression();
        }
    }

//    private static void setSplittedStrings(String input) {
//        splittedStrings = Arrays.asList(input.split(BLANK));
//        checkClusteredElements();
//        checkIfStartWithSymbol();
//    }

    public static void checkClusteredElements(List<String> splittedStrings) {
        IntStream.range(START_INDEX, splittedStrings.size() - 1).forEach(i -> {
            checkIfClustered(splittedStrings.get(i), splittedStrings.get(i + 1));
        });
    }

    public static void checkIfClustered(String prev, String post) {
        if (isNumber(prev) && isNumber(post)) {
            throw new IllegalArgumentException("숫자가 연속되면 안됩니다");
        }
        if (!isNumber(prev) && !isNumber(post)) {
            throw new IllegalArgumentException("연산자가 연속되면 안됩니다");
        }
    }

    public static void checkIsNumberOfListOdd(List<String> splittedStrings){
        if (splittedStrings.size() % 2 == 0) {
            throw new IllegalArgumentException("적절하지 않은 수식입니다");
        }
    }

    public static void checkIfStartWithSymbol(List<String> splittedStrings) {
        if (!isNumber(splittedStrings.get(START_INDEX))) {
            throw new IllegalArgumentException("숫자로 시작해야 합니다");
        }
    }

    private static Boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static void exitProgramIfDoNotInputCorrectExpressionFiveTimes(){
        if(errorCount == MAXIMUM_ERROR){
            OutputView.printExitMessage();
            System.exit(0);
        }
    }
}
