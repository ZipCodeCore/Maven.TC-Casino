package io.zipcoder.casino;

import java.util.Scanner;

public class InPutConsole {

    static Scanner scanner = new Scanner(System.in);

    private InPutConsole(){}

    public static String getInput(){

        return scanner.nextLine().toUpperCase();
    }
}
