package calculator;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Calculator {
    private Scanner sc = new Scanner(System.in);
    List<List> expressions = new ArrayList<>();

    List<String> initOpers() {
        return expressions.get(1);
    }
    List<Integer> initNums() {
        List<String> numbers = expressions.get(0);
        List<Integer> nums = new ArrayList<>();
        for(String number : numbers) {
            nums.add(Integer.parseInt(number));
        }
        return nums;
    }

    private int operation(int currNum, String oper, List<Integer> nums) {
       int result = 0;
       if("+".equals(oper)) {
           result = currNum + nums.remove(0);
       }
       else if("-".equals(oper)) {
           result = currNum - nums.remove(0);
       }
        else if("*".equals(oper)) {
           result = currNum * nums.remove(0);
        }
        else if("/".equals(oper)) {
           result = currNum / nums.remove(0);
        }
        return result;
    }

    public int calculate(int answer, List<Integer> nums, List<String> opers){
        for (int i = 0; i < opers.size(); i++) {
            answer = operation(answer, opers.get(i), nums);
        }
        return answer;
    }
}
