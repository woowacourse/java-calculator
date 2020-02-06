/*
 * Copyright (c) 2019 by tiger,DDoring
 * All rights reserved.
 *
 * Main.java
 * 프로그램 시작을 담당하는 클래스
 *
 * @author      tiger,DDoring
 * @version     1.0
 * @date        06 Feb 2020
 *
 */

package main;

import calculator.Calculator;
import validator.InputValidator;
import view.InputView;

public class Main {
    public static void main(String[] args) {
        InputView input = new InputView();
        String inputString;
        do {
            inputString = input.inputStringFromUser();
        } while(! new InputValidator().checkInput(inputString));

        String[] inputArr = inputString.split(" ");

        double sum = Double.parseDouble(inputArr[0]);
        Calculator calculator = new Calculator();

        for(int i = 1; i < inputArr.length-1; i += 2) {
            if(inputArr[i].equals("+")){
                sum = calculator.plus(sum, Double.parseDouble(inputArr[i+1]));
            }
            if(inputArr[i].equals("-")){
                sum = calculator.minus(sum, Double.parseDouble(inputArr[i+1]));
            }
            if(inputArr[i].equals("*")){
                sum = calculator.mul(sum, Double.parseDouble(inputArr[i+1]));
            }
            if(inputArr[i].equals("/")){
                sum = calculator.div(sum, Double.parseDouble(inputArr[i+1]));
            }
        }
    }
}