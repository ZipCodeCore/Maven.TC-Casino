package io.zipcoder.casino;

import java.util.Scanner;

public class GoFish extends GoFishGame {


    Scanner scanner = new Scanner(System.in);

    static GoFishGame goFishGame = new GoFishGame();

    public static void goFishRun() {

                    String response = "no";
                System.out.print("Welcome to the <GoFish> table!\n" +
                        "Insert nick name you want to use for the game? \n\n");
                goFishGame.getGoFishPlayer().setName(InPutConsole.getInput());
                do{   goFishGame.startGame();
               // goFishGame.playerHand();
               // goFishGame.computerHand();

                while (!goFishGame.getDeck().isEmpty()) {
                    System.out.println("Insert the rank of the card you want to request: ");
                    String rank = InPutConsole.getInput();
                    goFishGame.askComputerHandForACard(rank);

                   // goFishGame.removeBookedCard();
                    goFishGame.playerHandDisplay();
                    goFishGame.goFishingPlayer();
                    goFishGame.checkIfComputerHandHasAcard();
                    goFishGame.askPlayerForACard(goFishGame.computerCardToRequest());
                    goFishGame.goFishingComputer();
                   // goFishGame.countBooksInComputerHand();
                    // goFishGame.removeBookedCard();
                    // goFishGame.removeComputerBookedCard();
                    //goFishGame.checkPlayersCardRequestForGameRule(rank);
                    // goFishGame.removeBookedCard();

                }

                System.out.println("The game is over. Computer score is " +
                        goFishGame.countBooksInComputerHand());
                System.out.println(goFishGame.getGoFishPlayer().getName() +
                        " score is " +  goFishGame.countBooksInPlayerHand());
                goFishGame.decideWiner();
                System.out.println("Do you want to play again?");
                 response = InPutConsole.getInput();
//                if (response.toUpperCase().equalsIgnoreCase("yes")){
//                    goFishGame.startGame();

            } while (response.equalsIgnoreCase("yes"));
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
