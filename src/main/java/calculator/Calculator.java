package calculator;

import java.util.*;

public class Calculator {
    private Set opertors;
    private Queue<String> equation;

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

    public Queue makeQueue(String inputString) {
        String[] elements = inputString.split("\\s+", 0);
        return new LinkedList<>(Arrays.asList(elements));
    }
}
