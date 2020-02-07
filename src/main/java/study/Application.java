package study;

import java.util.Scanner;

import domain.Calculator;

public class Application {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("계산식을 입력하세요:");
		String value = scanner.nextLine();
		String[] values = value.split(" ");
		System.out.println(Calculator.calculate(values));
	}
}
