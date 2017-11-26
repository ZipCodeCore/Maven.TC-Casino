package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


   public class GoFishPlayer extends CardPlayer {
       private int score;
       private String name;
       private ArrayList<Card> hand;

       public GoFishPlayer(){super();};

       @Override
       public int getScore() {
           return score;
       }

       @Override
       public String getName() {
           return name;
       }

       @Override
       public ArrayList<Card> getHand() {
           return hand;
       }

       @Override
       public void setName(String name) {
           this.name = name;
       }

       @Override
       public void setScore(int score) {
           this.score = score;
       }
       //    public Card drawCard(Deck deck) {
//        Card playerCard = deck.getCards().remove(0);
//        return playerCard;
//    }
//
//    public void addCardToHand(Card card){
//       getHand().add(card);
//    }

//    public ArrayList<Card> getHand() {
//        return hand;
//    }
//
//    public boolean checkHandForCard(Rank rank){
//        for(Card card: hand){
//            if(card.getRank() == rank) return true;
//        }return false;
//
//    }
//
//    public Card giveCard(Rank rank){
//        for(Card card: hand){
//            if(card.getRank() == rank){
//                hand.remove(card);
//                return card;
//            }
//        }
//        return null;
//    }
//
//    public Suit checkFourOfAKind(){
//
//      //  Stream<Card> handStream = hand.stream().

}
