package calculator;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Calculator calculator = new Calculator();
        Output output = new Output();
        String[] splitString;

        try {
            splitString = input.inputFormula();
            output.printResult(calculator.calculate(splitString));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
