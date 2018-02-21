package io.zipcoder.casino;

import java.util.Scanner;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/21/18
 */
public class IOHandler {
    Scanner in = new Scanner(System.in);

    private int getInt() {
        return -1;
    }

    private String getString() {
        return null;
    }

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public int promptForIntWithMessage(String msg) {
        return -1;
    }

    public String promptForStringWithMessage(String msg) {
        return null;
    }
}
