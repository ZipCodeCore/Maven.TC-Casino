package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Deck {

    private ArrayList<String> deckOfCards;

    public Deck() {

        this.deckOfCards = new ArrayList(52);

        //for (int i = 0; i < value.length; i++){
        //    for (int x = 0; x < suit.length; x++){
        //        Card card = new Card(value[i], suit[x]);
        //        deckOfCards.add(card);
        //    }
        //}
    }

    public ArrayList<String> getDeckOfCards(){
        return this.deckOfCards;
    }


    public void shuffleDeck(){
        Collections.shuffle(this.deckOfCards);
    }

    public String drawCard(){

        String currentCard = "";

        for(int i = 0; i < deckOfCards.size(); i++) {
            if(deckOfCards.get(i) == null) {
                return "Out of Cards!";
            } else {
                currentCard = deckOfCards.get(i);
                deckOfCards.remove(0);
                break;
            }
        }



        return currentCard;
    }


}

