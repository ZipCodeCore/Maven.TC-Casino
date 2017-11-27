package io.zipcoder.casino;

import java.util.Scanner;

public class GoFish extends GoFishGame {


    Scanner scanner = new Scanner(System.in);



    public static void goFishRun() {

        String response = "no";
        System.out.print("Welcome to the <GoFish> table!\n" +
                "Insert nick name you want to use for the game? \n\n");

        do {

            GoFishGame goFishGame = new GoFishGame();
         goFishGame.getGoFishPlayer().setName(InPutConsole.getInput());
            goFishGame.startGame();
            goFishGame.playerHand();
            goFishGame.computerHand();

            while (!goFishGame.getDeck().isEmpty()) {
                System.out.println("Insert the rank of the card you want to request: ");
                String rank = InPutConsole.getInput();
                goFishGame.checkInput(rank);
                goFishGame.askComputerHandForACard(rank);
                goFishGame.playerHandDisplay();
                goFishGame.goFishingPlayer();
                goFishGame.checkIfComputerHandHasAcard();
                goFishGame.askPlayerForACard(goFishGame.computerCardToRequest());
                goFishGame.goFishingComputer();

            }

            System.out.println("The game is over");
            goFishGame.decideWiner();
            System.out.println("Do you want to play again?");
            response = InPutConsole.getInput();
        } while (response.equalsIgnoreCase("yes"));
        System.out.println("Bye bye, visit us again");
    }

}