package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exception.Exception;

public class Input {
    static Scanner sc = new Scanner(System.in);
    private List<String> nums;
    private List<String> opers;
    List<List> expressions = new ArrayList<>();
    private String value;
    private Exception exception = new Exception();

    public List<List> inputValue() {
        nums = new ArrayList<>();
        opers = new ArrayList<>();

        System.out.println("Enter Value : ");
        value = sc.nextLine();

        String[] valueMembers = value.split(" ");
        divideNumsAndOpers(valueMembers);

        if (!exception.isNumber(nums)) {
            System.out.println("not numbers");
            return inputValue();
        } else if (!exception.isValidOperator(opers)) {
            System.out.println("not opers");
            return inputValue();
        }
        expressions.add(nums);
        expressions.add(opers);
        return expressions;
    }

    private void divideNumsAndOpers(String[] valueMembers) {
        for (int i = 0; i < valueMembers.length; i++) {
            if (i % 2 == 0) {
                nums.add(valueMembers[i]);
            } else if (i % 2 == 1) {
                opers.add(valueMembers[i]);
            }
        }
    }
}

