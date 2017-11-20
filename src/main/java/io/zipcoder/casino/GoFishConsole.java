package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Scanner;

public class GoFishConsole extends Console{

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

    public void playerTurn(ArrayList<Player> players){
        System.out.println(players.get(0).getName()+ " your turn.");

        Rank rank = getRankInput();

        System.out.println(rank);
    }


    public Rank getRankInput(){
        Scanner scan = new Scanner(System.in);

        do {
            String stringInput = scan.nextLine();
            for (Rank rank : Rank.values()) {
                if (rank.toString().equalsIgnoreCase(stringInput)) {
                    return rank;
                }
            }
            System.out.println("Please enter a valid card.");
        } while (true);
    }
}
