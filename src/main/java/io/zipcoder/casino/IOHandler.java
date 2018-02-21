package io.zipcoder.casino;

import java.util.Scanner;
/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/21/18
 */
public final class IOHandler {
    private static Scanner getInScanner() {
       return new Scanner(System.in);
    }

    private static int getInt() {
       return Integer.parseInt(getInScanner().nextLine());
    }

    private static String getString() {
        return getInScanner().nextLine();
    }

    public static void printMessage(String msg) {
        System.out.println(msg);
    }

    public static int promptForIntWithMessage(String msg) {
        printMessage(msg);
        return getInt();
    }

    public static String promptForStringWithMessage(String msg) {
        printMessage(msg);
        return getString();
    }
}
