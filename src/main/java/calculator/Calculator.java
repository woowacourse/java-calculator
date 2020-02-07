package calculator;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import util.Input;

public class Calculator {
    private static Scanner sc = new Scanner(System.in);
    static List<Integer> nums = new ArrayList<>();
    static List<String> opers = new ArrayList<>();
    private String value;

    static void init(String[] valueArray) { // 숫자와 연산자를 나누어서 각 리스트를 만드는 함수
        value = Input.inputValue();
    }

    static int operation(int currNum, String oper) { // 연산자에 따른 연산을 하는 함수.
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

    static int calculate(int answer){
        for (int i = 0; i < opers.size(); i++) {        // 순서대로 연산을 한다. 초기 누적값은 nums의 첫번째 값으로 한다.
            answer = operation(answer, opers.get(i));   // 누적값을 연산한 결과로 변경하게 된다.
        }
        return answer;
}

    public static void main(String[] args) {
        String[] valueArray = Input.inputExpression();
        init(valueArray);

        int answer = nums.remove(0);
        answer = calculate(answer);
        System.out.println("Answer is " + calculate(answer));
    }
}
