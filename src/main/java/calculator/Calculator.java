package calculator;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import util.Input;

public class Calculator {
    private static Scanner sc = new Scanner(System.in);
    static List<List> expressions = new ArrayList<>();

    // Input에서 넘어온 리스트를 각 nums와 opers에 분배
    static List<String> initOpers() {
        return expressions.get(1);
    }
    // Input에서 넘어온 리스트를 각 nums와 opers에 분배
    static List<Integer> initNums() {
        List<String> numbers = expressions.get(0);
        List<Integer> nums = new ArrayList<>();
        for(String number : numbers) {
            nums.add(Integer.parseInt(number));
        }
        return nums;
    }

    static int operation(int currNum, String oper, List<Integer> nums, List<String> opers) { // 연산자에 따른 연산을 하는 함수.
       int result = 0;
       if(oper.equals("+")) {
           result = currNum + nums.remove(0);
       }
       else if(oper.equals("-")) {
           result = currNum - nums.remove(0);
       }
        else if(oper.equals("*")) {
           result = currNum * nums.remove(0);
        }
        else if(oper.equals("/")) {
           result = currNum / nums.remove(0);
        }
        return result;
    }

    public static int calculate(int answer, List<Integer> nums, List<String> opers){
        for (int i = 0; i < opers.size(); i++) {        // 순서대로 연산을 한다. 초기 누적값은 nums의 첫번째 값으로 한다.
            answer = operation(answer, opers.get(i), nums, opers);   // 누적값을 연산한 결과로 변경하게 된다.
        }
        return answer;
}

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        List<String> opers = new ArrayList<>();
        expressions = Input.inputValue();
        nums = initNums();
        opers = initOpers();
        int answer = nums.remove(0);
        answer = calculate(answer, nums, opers);
        System.out.println("Answer is " + answer);
    }
}
