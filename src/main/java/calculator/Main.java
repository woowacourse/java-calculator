package calculator;

public class Main {
    public static void main(String[] args) {
        UserInputScanner userInputScanner = new UserInputScanner();
        Calculator calculator = new Calculator();
        Output output = new Output();

        try {
            String[] splitString = userInputScanner.splitUserInputString();
            double result = calculator.calculate(splitString);
            output.printResult(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
