import domain.Calculator;

public class Application {
	public static void main(String[] args) {
		InputHandler inputHandler = new InputHandler();
		Calculator calculator = new Calculator();
		do {
			double result = calculator.run(inputHandler.getInput());
			System.out.println("정답은 " + result + " 입니다.");
		} while (inputHandler.isStartingAgain());
	}
}
