/*
 * Copyright (c) 2019 by tiger,DDoring
 * All rights reserved.
 *
 * InputView.java
 * 사용자의 입력을 담당하는 클래스
 *
 * @author      tiger,DDoring
 * @version     1.0
 * @date        06 Feb 2020
 *
 */

package view;

import java.util.Scanner;

public class InputView {
    public static String inputStringFromUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
