package domain;

import inputView.InputHandler;

public class Calculator {
	private double result;
	private InputHandler inputHandler;

	public Calculator(InputHandler inputHandler) {
		this.inputHandler = inputHandler;
	}

	public void run() {
		do {
			double result = getResult(inputHandler.getInput());
			System.out.println("정답은 " + result + " 입니다.");
		} while (inputHandler.isStartingAgain());
	}

	public double getResult(String[] input) {
		result = Double.parseDouble(input[0]);
		for (int i = 1; i < input.length; i += 2) {
			calculate(Double.parseDouble(input[i + 1]), input[i]);
		}
		return result;
	}

	private void calculate(double operand, String symbol) {
		for (Operator operator : Operator.values()) {
			result = operator.findAndExecute(result, operand, symbol);
		}
	}
}
