package calculator;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Calculator {
    private Set opertors;

    public Calculator() {
        opertors = new HashSet<>();
        opertors.add("+");
        opertors.add("-");
        opertors.add("/");
        opertors.add("*");
    }

    private String inputEquation(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
