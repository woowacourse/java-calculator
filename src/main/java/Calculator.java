import java.util.Scanner;

public class Calculator {
    static int returnValue;
    private static final int INDEX_INIT = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        String[] values = scanner.nextLine().split(" ");
        returnValue = Integer.parseInt(values[0]);
        for (int i = INDEX_INIT; i < values.length; i++) {
            //check 함수
        }
        System.out.println(returnValue);
    }
}
