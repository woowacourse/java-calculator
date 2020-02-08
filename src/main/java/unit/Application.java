package unit;

import unit.controller.CalculatorController;
import unit.domain.Calculator;

public class Application {
	public static void main(String[] args) {
		Calculator calculator = new Calculator(CalculatorController.inputExpression());
		CalculatorController.printResult(calculator);
	}
}
