package calculator;

import java.util.List;

public class Calculator {
    public int runCalculator(List<Integer> nums, List<String> opers) throws ArithmeticException {
        Operator.init();
        return calculate(nums, opers);
    }

    private int calculate(List<Integer> nums, List<String> opers) {
        int answer = nums.get(0);
        for (int i = 0; i < opers.size(); i++) {
            int num = nums.get(i + 1);
            String oper = opers.get(i);
            answer = Operator.startCalculate(oper).calculate(answer, num);
        }
        return answer;
    }
}
