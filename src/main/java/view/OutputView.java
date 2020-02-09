package view;

public class OutputView {
    public static void printAnswer(double returnValue) {
        if (returnValue == Math.rint(returnValue)) {
            System.out.println((int) returnValue);
            return;
        }
        System.out.println(returnValue);
    }
}
