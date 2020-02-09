package calculator.view;

import calculator.util.ExceptionHandler;

import java.util.InputMismatchException;
import java.util.Scanner;

import static calculator.util.ExceptionHandler.checkInputHandler;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static final String INPUT_EXPRESSION_STR = "식을 입력해주세요 : ";
    private static final String CHECK_INPUT_STR = "입력값을 확인해주세요!";

    public static String inputHandler() {
        try {
            return checkInputHandler(printInputExpression());
        } catch (InputMismatchException | IllegalArgumentException e) {
            printInputCheck();
            return inputHandler();
        }
    }

    public static String printInputExpression(){
        System.out.print(INPUT_EXPRESSION_STR);
        return scanner.nextLine();
    }

    public static void printInputCheck(){
        System.out.println(CHECK_INPUT_STR);
    }
}
