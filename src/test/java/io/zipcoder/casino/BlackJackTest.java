package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class BlackJackTest{
    BlackJack blackJack = new BlackJack();
    @Test
    public void testGiveHand(){
        Deck deckObj= new Deck();
        ArrayList<Card> deckBlackJAck = deckObj.createFullDeck();
        Assert.assertEquals(52,deckBlackJAck.size());
        ArrayList<Card> playHand = new ArrayList<Card>();
        blackJack.giveHand(deckBlackJAck,playHand);
        Assert.assertEquals(2,playHand.size());
        Assert.assertEquals(50,deckBlackJAck.size());
    }
    @Test
    public void testHit(){
        Deck deckObj= new Deck();
        ArrayList<Card> deckBlackJAck = deckObj.createFullDeck();
        Assert.assertEquals(52,deckBlackJAck.size());
        ArrayList<Card> playHand = new ArrayList<Card>();
        blackJack.giveHand(deckBlackJAck,playHand);
        blackJack.hit(deckBlackJAck,playHand);
        Assert.assertEquals(3,playHand.size());
        Assert.assertEquals(49,deckBlackJAck.size());
    }
    @Test
    public void testAddHandValues(){
        Deck deckObj= new Deck();
        ArrayList<Card> deckBlackJAck = deckObj.createFullDeck();
        ArrayList<Card> playHand = new ArrayList<Card>();
        Collections.shuffle(deckBlackJAck);
        blackJack.giveHand(deckBlackJAck,playHand);
        blackJack.hit(deckBlackJAck,playHand);
        System.out.println(playHand);
        System.out.println(blackJack.addHandValues(playHand));
        for (Card card:playHand) {
            System.out.println(card.getValue().getValue());
        }
    }
}
