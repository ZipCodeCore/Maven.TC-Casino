package io.zipcoder.casino;

import java.util.Scanner;

public class InputOutput {
    Scanner input = new Scanner(System.in);

    //MUST INSTANTIATE IN CASINO

    public String scanForString() {
        String stringReturn = new String();
        if (input.hasNext()) {
            stringReturn = input.nextLine();
        }
        return stringReturn;
    }

    public Integer scanForInt(){
        Integer integerReturn = input.nextInt();
        return integerReturn;
    }

//    public static void main(String[] args) {
//        InputOutput io = new InputOutput();
//        System.out.println("Enter your name");
//        String name = io.scanForString();
//        System.out.println(name);
//    }
}
