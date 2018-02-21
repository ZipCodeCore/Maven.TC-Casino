package io.zipcoder.casino;

import java.util.Scanner;

public class InputOutput {
    Scanner input = new Scanner(System.in);

    public String scanForString(){
        String stringReturn = new String();
        if (input.hasNext()){
            stringReturn = input.nextLine();
        }
        return stringReturn;
    }

    public Integer scanForInt(){
        Integer integerReturn = 0;
        while (!input.hasNextInt()) {
            System.out.println("Please enter a valid number");
            integerReturn = input.nextInt();
        }
        return integerReturn;
    }
}
