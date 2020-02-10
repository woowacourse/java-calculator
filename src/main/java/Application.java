import calculator.Calculator;
import input.InputScanner;
import output.OutputPrinter;

public class Application {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        InputScanner inputScanner = new InputScanner();
        OutputPrinter outputPrinter = new OutputPrinter();
        outputPrinter.printIntroduction();
        calculator.run(inputScanner, outputPrinter);
    }
}
