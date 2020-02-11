package calculator;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Calculator {
    List<String> initOpers(List<List> expressions) {
        return expressions.get(1);
    }
    List<Integer> initNums(List<List> expressions) {
        List<String> numbers = expressions.get(0);
        List<Integer> nums = new ArrayList<>();
        for(String number : numbers) {
            nums.add(Integer.parseInt(number));
        }
        return nums;
    }

    private int operation(int currNum, String oper, int target) {
       if("+".equals(oper)) {
           return currNum + target;
       }
       else if("-".equals(oper)) {
           return currNum - target;
       }
        else if("*".equals(oper)) {
           return currNum * target;
        }
        else if("/".equals(oper)) {
           return currNum / target;
        }
        return 0; // TODO
    }

    public int calculate(List<List> expressions){
        List<Integer> nums = initNums(expressions);
        List<String> opers = initOpers(expressions);
        int answer = nums.remove(0);

        for (int i = 0; i < opers.size(); i++) {
            int target = nums.remove(0);
            answer = operation(answer, opers.get(i), target);
        }
        return answer;
    }
}
