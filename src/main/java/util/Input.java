package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exception.ValidationCheck;

public class Input {
    private Scanner sc = new Scanner(System.in);
    private List<String> numbers = new ArrayList<>();
    private List<String> operators = new ArrayList<>();

    public List<List> expressions = new ArrayList<>();

    public List<List> inputValue() {
        String value;
        ValidationCheck validationCheck = new ValidationCheck();

        System.out.println("Enter Value : ");
        value = sc.nextLine();

        String[] valueMembers = value.split(" ");

        if(!validationCheck.isValid(valueMembers)) {
            return inputValue();
        }

        divideNumsAndOpers(valueMembers);

        expressions.add(numbers);
        expressions.add(operators);
        return expressions;
    }

    private void divideNumsAndOpers(String[] valueMembers) {
        for (int i = 0; i < valueMembers.length; i++) {
            addNumbersOrOperators(i, valueMembers);
        }
    }

    private void addNumbersOrOperators(int i, String[] valueMembers){
        boolean isNumberPlace = (i % 2 == 0);

        if (isNumberPlace) {
            numbers.add(valueMembers[i]);
        } else if (!isNumberPlace) {
            operators.add(valueMembers[i]);
        }
    }
}

