package calculator;

import java.util.HashSet;
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
}
