package io.zipcoder.casino;

import io.zipcoder.casino.Console.Console;
import io.zipcoder.casino.Deck.Card;

import java.util.ArrayList;

public class GoFish extends CardGame {

    private int playerBookCount = 0;
    private int dealerBookCount = 0;


    public GoFish(){

    }

    private void playerAsk(){

    }

    private boolean dealerAsk(){
        return false;
    }

    private boolean isCardInHand(Card askCard, ArrayList<Card> hand){
        for(Card card:hand){
            if(card.fishValue = askCard.fishValue){
                return true;
            }
        }
        return false;
    }

    private void removeCard(Card card, ArrayList<Card> hand){

    }
    private void compareBooks(){
        if(playerBooks > dealerBooks){
            System.out.println("You win!");
        }
        else if(playerBooks < dealerBooks){
            System.out.println("You lose!");
        }
        else{
            System.out.println("Tie!");
        }
    }


}
