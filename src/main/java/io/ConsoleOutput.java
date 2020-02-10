package io;

public class ConsoleOutput {
    public void printStartMessage() {
        System.out.println("계산기를 시작합니다.");
    }

    public void printResult(Double result) {
        System.out.println("결과 : " + result);
    }

    public void printEndMessage() {
        System.out.println("계산기를 종료합니다.");
    }
}
