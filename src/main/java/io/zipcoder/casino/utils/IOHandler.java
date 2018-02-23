package io.zipcoder.casino.utils;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
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

    public static String getMessageFromFile(String file) {
        String ret = "[file not found]";
        try {
            String pathString = IOHandler.class.getResource(file).getPath();
            Path path = FileSystems.getDefault().getPath(pathString);

            try {
                ret = linesToString(Files.readAllLines(path));
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (NullPointerException npe) {
            npe.getMessage(); // this is bad, i'm sorry.
        }
        return ret;
    }

    private static <T> String linesToString(List<T> list) {
        StringBuilder sb = new StringBuilder();
        for (T t : list) {
            sb.append(t.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
