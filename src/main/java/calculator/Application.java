package calculator;


import view.InputView;
import view.OutputView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args){
        Calculator calculator = new Calculator();
        boolean isContinue = true;
        while (isContinue) {
            calculator.enterMathematicalExpression();
            OutputView.printAnswer(calculator.calculate());
            isContinue = InputView.enterYesNo();
        }
    }
}
