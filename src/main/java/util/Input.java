package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import exceptionhandler.ExceptionHandler;

public class Input {
    private static int NUMBER = 0;
    private static int OPERATION = 1;
    private static Scanner sc = new Scanner(System.in);
    private static String value;
    private static List<List> expressions = new ArrayList<>();
    private static ExceptionHandler exceptionHandler = new ExceptionHandler();
    private static String[] valueMembers;

    public static List<List> inputValue() {
        List<String> nums = new ArrayList<>();
        List<String> opers = new ArrayList<>();
        System.out.println("Enter Value : ");
        value = sc.nextLine();
        valueMembers = value.split(" ");
        for (int i = 0; i < valueMembers.length; i++) {
            separateValues(i, nums, opers);
        }
        if (!exceptionHandler.isNumber(nums)) {
            System.out.println("not numbers");
            return inputValue();
        } else if (!exceptionHandler.isValidOperator(opers)) {
            System.out.println("not operations");
            return inputValue();
        }
        expressions.add(nums);
        expressions.add(opers);
        return expressions;
    }

    private static void separateValues(int idx, List<String> nums, List<String> opers) {
        if (idx % 2 == NUMBER) {
            nums.add(valueMembers[idx]);
        } else if (idx % 2 == OPERATION) {
            opers.add(valueMembers[idx]);
        }
    }
}