package calculator;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Calculator {
    private Map<String, Operator> cal = new HashMap<>();

    public int runCalculator(List<Integer> nums, List<String> opers) throws ArithmeticException {
        initCalculator();
        return calculate(nums, opers);
    }

    private void initCalculator() {
        cal.put("+", Operator.PLUS);
        cal.put("-", Operator.MINUS);
        cal.put("*", Operator.MULTIPLY);
        cal.put("/", Operator.DIVIDE);
    }

    private int calculate(List<Integer> nums, List<String> opers) {
        int answer = nums.get(0);
        for (int i = 0; i < opers.size(); i++) {
            int num = nums.get(i + 1);
            String oper = opers.get(i);
            answer = cal.get(oper).calculate(answer, num);
        }
        return answer;
    }
}
