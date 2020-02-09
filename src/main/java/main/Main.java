package main;

import util.Input;
import calculator.Calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int NUMS = 0;
    private static final int OPERS = 1;
    private static final String ERR_CANT_DIVIDE_BY_ZERO = "0으로 나눌 수 없습니다.";
    private static List<List> expressions = new ArrayList<>();
    private static Calculator calculator = new Calculator();

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        List<String> opers = new ArrayList<>();
        expressions = Input.inputValue();
        nums = initNums();
        opers = initOpers();
        try {
            System.out.println(calculator.runCalculator(nums, opers));
        } catch (ArithmeticException e) {
            System.err.println(ERR_CANT_DIVIDE_BY_ZERO);
            e.printStackTrace();
        }
    }

    private static List<Integer> initNums() {
        List<String> numbers = expressions.get(NUMS);
        List<Integer> nums = new ArrayList<>();
        for (String number : numbers) {
            nums.add(Integer.parseInt(number));
        }
        return nums;
    }

    private static List<String> initOpers() {
        return expressions.get(OPERS);
    }
}
