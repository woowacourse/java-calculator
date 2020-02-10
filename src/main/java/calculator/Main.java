package calculator;

import util.Input;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Calculator calculator = new Calculator();

        List<Integer> nums = new ArrayList<>();
        List<String> opers = new ArrayList<>();
        List<List> expressions = new ArrayList<>();

        expressions = input.inputValue();
        nums = calculator.initNums(expressions);
        opers = calculator.initOpers(expressions);
        int answer = nums.remove(0);
        answer = calculator.calculate(answer, nums, opers);
        System.out.println("Answer is " + answer);
    }
}
