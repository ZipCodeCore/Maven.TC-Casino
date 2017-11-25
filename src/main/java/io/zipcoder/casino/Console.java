package io.zipcoder.casino;

import java.util.Scanner;
import java.util.WeakHashMap;

import static io.zipcoder.casino.CrapsConsole.playCraps;

public class Console {

    public static void main(String[] args) {

        casinoHome();

    }

    public static void casinoHome(){
        displayWelcomeMessage();
        selectGame();
    }


    private static void selectGame() {
        System.out.println("Which of our fine games would you like to try first?\n" +
                            "Enter 'blackjack' or 'b' to play BlackJack\n" +
                            "Enter 'craps' or 'c' to play Craps\n" +
                            "Enter 'GoFish or 'g to Go Fish.\n" +
                            "Type exit to quit");

        Scanner scan = new Scanner(System.in);
        String input;
        do{
            input = scan.next();
            if(!input.equalsIgnoreCase("blackjack")&&!input.equalsIgnoreCase("b")&&
                    !input.equalsIgnoreCase("craps")&&!input.equalsIgnoreCase("c")&&
                            !input.equalsIgnoreCase("gofish")&&!input.equalsIgnoreCase("g")&&
                                !input.equalsIgnoreCase("exit")){
                System.out.println("I'm sorry that's not a valid entry");
            }
        }while(!input.equalsIgnoreCase("blackjack")&&!input.equalsIgnoreCase("b")&&
                !input.equalsIgnoreCase("craps")&&!input.equalsIgnoreCase("c")&&
                !input.equalsIgnoreCase("gofish")&&!input.equalsIgnoreCase("g")&&
                !input.equalsIgnoreCase("exit"));

        if(input.equalsIgnoreCase("blackjack")||input.equalsIgnoreCase("b")) {
           // playBlackJack();
        }
        else if(input.equalsIgnoreCase("craps")||input.equalsIgnoreCase("c")){
            playCraps();
        }
        else if(input.equalsIgnoreCase("gofish")||input.equalsIgnoreCase("g")){
            playCraps();
        }else if(input.equalsIgnoreCase("exit")){
            System.exit(0);
        }
    }


    private static void displayWelcomeMessage() {
        System.out.println("Welcome to our casino. Where the slots are are loose\n" +
                           "and the banker is liberal with credit\n");
    }

}


