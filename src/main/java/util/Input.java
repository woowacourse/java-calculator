package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import exception.Exception;

public class Input {
    static Scanner sc = new Scanner(System.in);
    static List<List> expressions = new ArrayList<>();
    private static String value;
    private static Exception exception = new Exception();

    public static List<List> inputValue() {
        List<String> nums = new ArrayList<>();
        List<String> opers = new ArrayList<>();
        System.out.println("Enter Value : ");
        value = sc.nextLine();
        String[] valueMembers = value.split(" ");
        for (int i = 0; i < valueMembers.length; i++) {
            if (i % 2 == 0) {
                nums.add(valueMembers[i]);
            } else if (i % 2 == 1) {
                opers.add(valueMembers[i]);
            }
        }
        if (!exception.isNumber(nums)) {                // 숫자가 들어갈 인덱스에 숫자 외의 값이 들어가 있는지 확인.
            System.out.println("not numbers");
            return inputValue();
        } else if (!exception.isValidOperator(opers)) { // 연산자가 들어갈 인덱스에 연산자 외의 값이 들어가 있는지 확인.
            System.out.println("not opers");
            return inputValue();
        }
        expressions.add(nums);
        expressions.add(opers);
        return expressions;
    }
}

