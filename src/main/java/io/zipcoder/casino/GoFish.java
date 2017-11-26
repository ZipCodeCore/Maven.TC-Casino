package io.zipcoder.casino;

import java.util.Scanner;

public class GoFish extends GoFishGame {


    Scanner scanner = new Scanner(System.in);

    static GoFishGame goFishGame = new GoFishGame();

    public static void goFishRun() {

        System.out.print("Welcome to the <GoFish> table!\n" +
                "Insert nick name you want to use for the game? \n\n");
        goFishGame.getGoFishPlayer().setName(InPutConsole.getInput());

        String response = "No";

        goFishGame.startGame();
        goFishGame.playerHand();
        goFishGame.computerHand();
                int i =0;

            do {

                while (!goFishGame.getDeck().isEmpty()) {
                    System.out.println("Insert the rank of the card you want to request: ");
                    String rank = InPutConsole.getInput();
                    goFishGame.askComputerHandForACard(rank);
                    goFishGame.playerHandDisplay();
                    goFishGame.goFishingPlayer();
                    // goFishGame.removeBookedCard();
                    goFishGame.checkIfComputerHandHasAcard();
                    goFishGame.askPlayerForACard(goFishGame.computerCardToRequest());
                    goFishGame.goFishingComputer();
                 // goFishGame.removeComputerBookedCard();

                }
                System.out.println("The deck has finished");
                System.out.println("Computer score is " + goFishGame.getComputerPlayer().getScore());
                System.out.println( goFishGame.getGoFishPlayer().getName() + " score is " + goFishGame.getGoFishPlayer().getScore());
                goFishGame.decideWiner();
                System.out.println("Do you want to play again?");
                response = InPutConsole.getInput();
                if(response.toUpperCase().equalsIgnoreCase("yes")){
                    goFishGame.startGame();

                }
                else{
                    i=1;
                    }
            } while (i==0);
        System.out.println("Bye bye, visit us again");
    }

 /*   public void playGoFish(

            do {

                game.player1turn();

                    player1.askForCard();
                        if player2hascard
                            getCard
                            player1turn;
                            check for pairs
                            checkdeckempty
                        else player2doesnthave card
                            GOFISH. player1 draws card

                player2turn();

                    player1.askForCard();
                        if player2hascard
                            getCard
                            player2turn;
                            check for pairs
                            checkdeckempty
                        else player2doesnthave card
                            GOFISH. player1 draws card
    }
    */

//    public void playerTurn(ArrayList<Player> players){
//        System.out.println(players.get(0).getName()+ " your turn.");
//
//        Rank rank = getRankInput();
//
//        System.out.println(rank);
//    }
//
//
//    public Rank getRankInput(){
//        Scanner scan = new Scanner(System.in);
//
//        do {
//            String stringInput = scan.nextLine();
//            for (Rank rank : Rank.values()) {
//                if (rank.toString().equalsIgnoreCase(stringInput)) {
//                    return rank;
//                }
//            }
//            System.out.println("Please enter a valid card.");
//        } while (true);
//    }
}
