package calculator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args){
        Calculator calculator = new Calculator();
        boolean wantMore = true;
        while (wantMore) {
            calculator.enterMathematicalExpression();
            System.out.println(calculator.calculate());
        }
    }
}
