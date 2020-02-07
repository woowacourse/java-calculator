import domain.Calculator;

public class Application {
	public static void main(String[] args) {
		new Calculator().calculate(new InputHandler().getInput());
	}
}
