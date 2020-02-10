import calculator.Calculator;
import io.ConsoleInput;
import io.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        ConsoleOutput consoleOutput = new ConsoleOutput();
        Calculator calculator = new Calculator();

        calculator.run(consoleInput, consoleOutput);
    }
}
