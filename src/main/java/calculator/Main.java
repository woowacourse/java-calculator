package calculator;

import util.Input;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Calculator calculator = new Calculator();
        List<List> expressions;

        expressions = input.inputValue();
        int answer = calculator.calculate(expressions);
        System.out.println("Answer is " + answer);
    }
}
