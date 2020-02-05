package com.woowacourse.calculator.view;

public class OutputView {
    private static final String RETRY_INPUT_NOTICE_MESSAGE = "잘못된 입력입니다. 다시 입력해주세요";

    // 묵시적 생성자 방지
    public OutputView() {}

    public static void printRetryMessage() {
        System.out.println(RETRY_INPUT_NOTICE_MESSAGE);
    }
}
