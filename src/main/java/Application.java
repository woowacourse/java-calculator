import calculator.Calculator;
import view.InputView;

public class Application {

	public static void main(String[] args) {
		while (true){
			String input = InputView.inputExpression();
			Calculator.doOneCycle(input);
		}
	}

}
