package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import domain.errors.InvalidInputException;

public class Converter {
    public static final int FIRST_INDEX = 0;
    public static final int SECOND_INDEX = 1;

    public NumberSentence getNumberSentence(String sentence) throws InvalidInputException {
        validate(sentence);

        String[] arguments = sentence.split(" ");
        List<String> arg = Arrays.asList(arguments);

        return creatNumberSentence(arg);
    }

    private void validate(String sentence) throws InvalidInputException {
        if (sentence.isEmpty()) {
            throw new InvalidInputException("Input is empty");
        }

        for (int i = 0; i < sentence.length(); i++) {
            validateEachChar(i, sentence.charAt(i));
        }
    }

    private void validateEachChar(int index, char character) throws InvalidInputException {
        if (index % 2 != 0 && character != ' ') {
            throw new InvalidInputException("Input does not fit input standard");
        }
        if (index % 4 == 0) {
            int num = Integer.parseInt(String.valueOf(character));
        }
        if ((index % 4 != 0 && index % 2 == 0) && !isOperator(character)) {
            throw new InvalidInputException("There something not operator in operator place");
        }
    }

    private boolean isOperator(char operator) {
        return Operator.PLUS.equals(operator) || Operator.MINUS.equals(operator) ||
                Operator.MULTIPLIFICATION.equals(operator) || Operator.DIVISION.equals(operator);
    }

    private NumberSentence creatNumberSentence(List<String> arguments) {
        List<Number> numbers = new ArrayList<>();
        Queue<Operator> operators = new LinkedList<>();

        for (int i = FIRST_INDEX; i < arguments.size(); i += 2) {
            numbers.add(new Number(Integer.parseInt(arguments.get(i))));
        }

        for (int i = SECOND_INDEX; i < arguments.size(); i += 2) {
            Operator operator = getOperator(arguments.get(i).charAt(FIRST_INDEX));
            operators.add(operator);
        }

        return new NumberSentence(numbers, operators);
    }

    private Operator getOperator(char operator) {
        if (Operator.PLUS.equals(operator)) {
            return Operator.PLUS;
        } else if (Operator.MINUS.equals(operator)) {
            return Operator.MINUS;
        } else if (Operator.MULTIPLIFICATION.equals(operator)) {
            return Operator.MULTIPLIFICATION;
        } else {
            return Operator.DIVISION;
        }
    }
}
