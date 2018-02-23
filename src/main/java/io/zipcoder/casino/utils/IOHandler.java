package io.zipcoder.casino.utils;

import java.io.*;
import java.util.Scanner;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/21/18
 */
public final class IOHandler {
    private static Scanner getInScanner() throws IOException {
        return new Scanner(System.in);
    }

    private static int getInt() {
        Integer ret = 0;
        try {
            ret = Integer.parseInt(getInScanner().nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    private static String getString() {
        String ret = "";
        try {
            ret = getInScanner().nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
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

    /**
     * File IO
     */

    public static String getMessageFromFile(String pathString) {
        File file = new File(pathString);
        return getReader(file).lines().toString();
    }

    private static BufferedReader getReader(File file) {
        try {
            return new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
