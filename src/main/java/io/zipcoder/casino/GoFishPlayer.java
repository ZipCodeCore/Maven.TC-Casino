package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GoFishPlayer extends CardPlayer {


    public Card drawCard(Deck deck) {
        Card playerCard = deck.getCards().remove(0);
        return playerCard;
    }

}

   /* public Suit checkFourOfAKind(){


     Stream<Card> handStream = hand.stream();
>>>>>>> a373b1c3249a98a037ab65243ba0b3172174ebb5

        *//*  int diamonds = 0;
        int spades = 0;
        int hearts = 0;
        int clubs =0;

        for(Card card: hand){
            if (card.getSuit() == Suit.DIAMOND) {
                diamonds++;
                if (diamonds == 4) return Suit.DIAMOND;
            }
            if (card.getSuit() == Suit.HEART){
                hearts++;
                if (hearts == 4) return Suit.HEART;
            }
            if (card.getSuit() == Suit.CLUB) {
                clubs++;
                if (clubs == 4) return Suit.CLUB;
            }
            if (card.getSuit() == Suit.SPADE) {
                spades++;
                if (spades == 4) return Suit.SPADE;
            }
        }return null;



//    public void drawFiveCards(Deck deck){
//        for(int i = 0; i<5; i++){
//            hand.add(drawCard(deck));
//        }


}
*/