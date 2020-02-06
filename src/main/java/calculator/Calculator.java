package calculator;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Calculator {
    private static Scanner sc = new Scanner(System.in);
    int answer;
    static List<String> nums = new ArrayList<>();
    static List<String> opers = new ArrayList<>();

    static void init(String[] valueArray) {
        for (int i = 0; i < valueArray.length; i++) {
            if (i % 2 == 0) {
                nums.add(valueArray[i]);
            } else if (i % 2 == 1) {
                opers.add(valueArray[i]);
            }
        }
    }

    static int operation(int currNum, String oper) {
        int result = 0;
       if(oper.equals("+")) {
           System.out.println(currNum + "+" + nums.get(0));
           result = currNum + Integer.parseInt(nums.remove(0));
       }
       else if(oper.equals("-")) {
           System.out.println(currNum + "-" + nums.get(0));
           result = currNum - Integer.parseInt(nums.remove(0));
       }
        else if(oper.equals("*")) {
           System.out.println(currNum + "*" + nums.get(0));
            result = currNum * Integer.parseInt(nums.remove(0));
        }
        else if(oper.equals("/")) {
           System.out.println(currNum + "/" + nums.get(0));
            result = currNum / Integer.parseInt(nums.remove(0));
        }
        return result;
    }

    public static void main(String[] args) {
        String value = sc.nextLine();
        String[] valueArray = value.split(" ");
        init(valueArray);
        int answer = Integer.parseInt(nums.remove(0));
        for (int i = 0; i < opers.size(); i++) {
            answer = operation(answer, opers.get(i));
            System.out.println("Answer is " + answer);
        }
        System.out.println("Final answer is " + answer);
    }
}
