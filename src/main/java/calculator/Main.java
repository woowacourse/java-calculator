package calculator;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Calculator calculator = new Calculator();
        Output output = new Output();

        String[] splitString = input.splitString();
        double result = calculator.calculate(splitString);
        output.printResult(result);
    }
}
