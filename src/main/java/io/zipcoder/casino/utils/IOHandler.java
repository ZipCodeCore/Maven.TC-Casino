package io.zipcoder.casino.utils;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;

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

    /**
     * Returns a Stream of lines from the desired file, if the file exists. When using,
     * check that the returned stream != null
     * @param pathString the desired relative filepath
     * @return A stream of lines from the file as String
     */
    public static Stream<String> getMessageFromFile(String pathString) {
        File file = new File(pathString);
        return getReader(file).lines();
    }

    public static void writeMessageToFile(String pathString, String message, boolean append) {
        File file = new File(pathString);

    }

    private static BufferedReader getReader(File file) {
        try {
            return new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static BufferedWriter getWriter(File file, boolean append) {
        try {
            return new BufferedWriter(new FileWriter(file));
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
