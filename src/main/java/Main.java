import java.io.BufferedReader;
import java.io.IOException;

import domain.Calculator;
import utils.InputUtil;
import view.OutputView;

public class Main {
	public static void main(String[] args) {
		try {
			BufferedReader input = new InputUtil().input();
			Calculator calculator = new Calculator(InputUtil.inputMathematicalExpression(input));
			OutputView.showResult(calculator.calculate());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
