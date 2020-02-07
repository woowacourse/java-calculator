import domain.Calculator;

public class Application {
	public static void main(String[] args) {
		InputHandler inputHandler = new InputHandler();
		do {
			new Calculator().run(inputHandler.getInput());
		} while (inputHandler.isStartingAgain());
	}
}
