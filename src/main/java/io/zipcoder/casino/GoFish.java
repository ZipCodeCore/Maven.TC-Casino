package io.zipcoder.casino;

import java.util.Scanner;

public class GoFish extends GoFishGame {



    Scanner scanner = new Scanner(System.in);

    static GoFishGame goFishGame = new GoFishGame();

    public static void goFishRun(){

        System.out.print("Welcome to the <GoFish> table!");


        String response = "No";

        goFishGame.startGame();
        goFishGame.playerHand();
        goFishGame.computerHand();

        try {
        do {

            while (!goFishGame.getDeck().isEmpty()) {
                //System.out.println(goFishGame.getComputerHand());
                System.out.println("Insert the rank of the card you want to request: ");
                String rank = InPutConsole.getInput();
                goFishGame.checkInput(rank);
                goFishGame.playerHandDisplay();
               // goFishGame.increasePlayerScoreForBook();
                goFishGame.goFishingPlayer();

                goFishGame.checkIfComputerHandHasAcard();
                goFishGame.askPlayerForACard(goFishGame.computerCardToRequest());
               // goFishGame.checkComputerForBook();
                goFishGame.goFishingComputer();

                // System.out.println(goFishGame.getPlayerHand());
            }

            System.out.println("The deck has finished");
            //  goFishGame.increasePlayerScore();

            // goFishGame.increaseComputerScore();

            System.out.println("Computer score is " + goFishGame.getComputerPlayer().getScore());
            System.out.println("Your score is " + goFishGame.getGoFishPlayer().getScore());
            goFishGame.decideWiner();
            System.out.println("Do you want to play again?");
            response = InPutConsole.getInput();
        } while (response == "YES");
    } catch (Exception e) {
        System.out.println("please insert YES or NO" );
    }
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
