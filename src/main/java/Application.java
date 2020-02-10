import domain.Calculator;
import inputView.InputHandler;

public class Application {
	public static void main(String[] args) {
		InputHandler inputHandler = new InputHandler();
		Calculator calculator = new Calculator(inputHandler);
		calculator.run();
	}
}
