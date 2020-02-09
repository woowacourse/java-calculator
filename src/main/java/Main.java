public class Main {
    public static void main(String[] args) throws IllegalArgumentException{
        InputValues inputValues = new InputValues();
        Calculator calculator = new Calculator();

        calculator.calculate(inputValues);
        OutputView.printResult(calculator);
    }
}
