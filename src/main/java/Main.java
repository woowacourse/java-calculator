public class Main {
    public static void main(String[] args) throws IllegalArgumentException{
        Input input = new Input();
        InputValues inputValues = new InputValues(input);
        Calculator calculator = new Calculator();

        calculator.calculate(inputValues);
        OutputView.printResult(calculator);
    }
}
