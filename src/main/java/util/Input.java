package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {
    static Scanner sc = new Scanner(System.in);
    private static final String PATTERN = "(^[0-9]*$)";
    private static final String PATTS = "[+-*/]";

    public static String[] inputExpression() {
        System.out.println("Enter the Expression");
        String expression = sc.nextLine();
        String[] valueArray = expression.split(" ");
        return valueArray;
    }

    public static int inputNumber(String value) {
        if (!isNumber(value)) {
            System.out.println("It is not number");
            inputExpression();
        }
        return Integer.parseInt(value);
    }

    private static boolean isNumber(String value) {
        if (Pattern.matches(PATTERN, value)) {
            return true;
        }
        return false;
    }

    public static String inputOperator(String value) {
        if (!isOper(value)) {
            System.out.println("It is not operator");
            inputExpression();
        }
        return value;
    }

    private static boolean isOper(String value) {
        if (Pattern.matches(PATTS, value)) {
            return true;
        }
        return false;
    }
}

