public class Main {
    public static void main(String[] args) {
        InputValues inputValues = new InputValues();
        Calculator calculator = new Calculator();

        calculator.calculate(inputValues);
        calculator.printResult();
    }
}
