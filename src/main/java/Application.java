import calculator.Calculator;
import view.InputView;

public class Application {

	public static void main(String[] args) {
		while (true){

			try {
				String input = InputView.inputExpression();
				Double result = Calculator.calculate(input);
				System.out.println("계산 결과: " + result);
			}catch (Exception e){
				System.out.println(e.getMessage());
			}

		}
	}

}
