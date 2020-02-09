import java.io.IOException;

import domain.Calculator;
import utils.InputUtil;
import view.OutputView;

public class Main {
	public static void main(String[] args) {
		try {
			Calculator calculator = new Calculator(InputUtil.inputMathematicalExpression());
			OutputView.showResult(calculator.calculate());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
