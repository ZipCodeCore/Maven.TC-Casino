package io.zipcoder.casino;

import io.zipcoder.casino.Console.Console;
import io.zipcoder.casino.Deck.Card;

import java.util.ArrayList;

public class GoFish extends CardGame {

    private int playerBookCount = 0;
    private int dealerBookCount = 0;
    Player dealer = new Player("Dealer", 0,6);

    public GoFish(){

    }

    public void goFishStart(){
        deal(casinoplayer, dealer, 7);
        Console.print(casinoplayer.getStringDisplayHand());
        getCard("Give me all your: ");



    }

    private void playerAsk(){

    }

    private boolean dealerAsk(){
        return false;
    }

//    private boolean isCardInHand(Card askCard, ArrayList<Card> hand){
//        for(Card card:hand){
//            if(card.fishValue = askCard.fishValue){
//                return true;
//            }
//        }
//        return false;
//    }

//    private Card getCard(String prompt){
//        Console.print(prompt);
//
//
//    }

//    private void removeCard(Card card, ArrayList<Card> hand){
//
//    }
//    private void compareBooks(){
//        if(playerBooks > dealerBooks){
//            System.out.println("You win!");
//        }
//        else if(playerBooks < dealerBooks){
//            System.out.println("You lose!");
//        }
//        else{
//            System.out.println("Tie!");
//        }
    }


}
