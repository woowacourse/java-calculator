import domain.Calculator;

public class Application {
	public static void main(String[] args) {
		InputHandler inputHandler = new InputHandler();
		do {
			System.out.println("정답은 " + new Calculator().run(inputHandler.getInput()) + " 입니다.");
		} while (inputHandler.isStartingAgain());
	}
}
