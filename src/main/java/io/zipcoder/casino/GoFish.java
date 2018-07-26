package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Scanner;

public class GoFish extends CardGames {

    public ArrayList<GoFishPlayer> goFishPlayers = new ArrayList<>();
    private Deck goFishDeck;

    public void createOnePlayer(String name){
        GoFishPlayer goFishPlayer = new GoFishPlayer(name);
        goFishPlayers.add(goFishPlayer);
    }

    public void showEverybodysHand(){
        for(GoFishPlayer player: goFishPlayers){
            System.out.println(player.getName() + " this is your hand.\n");
            System.out.println(player.viewHand());
            System.out.println("");
        }
    }

    public void askOtherPlayerForCard(){
        System.out.println(goFishPlayers.get(1).getName()+"\n");
        System.out.println(goFishPlayers.get(1).viewHand()+"\n");
    }

    public void askFirstPlayerForCard(){
        System.out.println(goFishPlayers.get(0).getName()+"\n");
        System.out.println(goFishPlayers.get(0).viewHand()+"\n");

    }


    public ArrayList<GoFishPlayer> getPlayers() {
        return goFishPlayers;
    }

    public GoFishPlayer getPlayerAtIndex(int index) {
        return goFishPlayers.get(index);
    }

}
