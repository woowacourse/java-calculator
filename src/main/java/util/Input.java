package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exception.ValidationCheck;

public class Input {
    private Scanner sc = new Scanner(System.in);
    private List<String> numbers;
    private List<String> operators;
    private ValidationCheck validationCheck = new ValidationCheck();

    public List<List> expressions = new ArrayList<>();

    public List<List> inputValue() {
        String value;

        numbers = new ArrayList<>();
        operators = new ArrayList<>();

        System.out.println("Enter Value : ");
        value = sc.nextLine();

        String[] valueMembers = value.split(" ");
        divideNumsAndOpers(valueMembers);

        if(!isValid()) {
            return inputValue();
        }

        expressions.add(numbers);
        expressions.add(operators);
        return expressions;
    }

    private void divideNumsAndOpers(String[] valueMembers) {
        for (int i = 0; i < valueMembers.length; i++) {
            addNumbersOrOperators(i, valueMembers);
        }
    }

    private boolean isValid(){
        if (!validationCheck.isNumber(numbers)) {
            System.out.println("not numbers");
            return false;
        } else if (!validationCheck.isValidOperator(operators)) {
            System.out.println("not opers");
            return false;
        }
        return true;
    }

    private void addNumbersOrOperators(int i, String[] valueMembers){
        boolean isNumberPlace = (i % 2 == 0);
        boolean isOperatorPlace = (i%2 == 1);

        if (isNumberPlace) {
            numbers.add(valueMembers[i]);
        } else if (isOperatorPlace) {
            operators.add(valueMembers[i]);
        }
    }
}

