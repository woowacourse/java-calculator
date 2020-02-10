/*
 * Copyright (c) 2019 by 또링
 * All rights reserved.
 *
 * InputView.java
 * 사용자의 입력을 담당하는 클래스
 *
 * @author      또링
 * @version     1.0
 * @date        09 Feb 2020
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
