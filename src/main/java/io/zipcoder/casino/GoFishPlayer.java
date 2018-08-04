package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.HashMap;

public class GoFishPlayer extends CardPlayer<GoFish> {

    private ArrayList<CardPile> books = new ArrayList<>();

    public GoFishPlayer(String name) {
        super(name);
    }

    public boolean fishForCards(GoFishPlayer otherPlayer, Card.FaceValue rank) {
        if(otherPlayer.hasCardsOfRank(rank)) {
            return true;
        } else {
            return false;
        }
    }

    public CardPile handOverAllCardsRequested(Card.FaceValue rank) {
        CardPile toHandOver = new CardPile();
        for(Card card : this.getHand().getCards()) {
            if(card.getFaceValue().equals(rank)) {
                toHandOver.addCardToPile(card);
            }
        }
        for(Card card : toHandOver.getCards()) {
            this.getHand().removeCard(card);
        }
        return toHandOver;
    }

    public Integer playPotentialBooksInHand() {
        HashMap<Card.FaceValue, Integer> numberOfEachValue = new HashMap<>();
        for(Card card : getHand().getCards()) {
            Card.FaceValue key = card.getFaceValue();
            if(numberOfEachValue.containsKey(key)) {
                numberOfEachValue.put(key, numberOfEachValue.get(key) + 1);
            } else {
                numberOfEachValue.put(key, 1);
            }
        }

        ArrayList<Card.FaceValue> fourOfAKindValues = new ArrayList<>();

        for(Card.FaceValue value : numberOfEachValue.keySet()) {
            if(numberOfEachValue.get(value) == 4) {
                fourOfAKindValues.add(value);
            }
        }

        for(Card.FaceValue value : fourOfAKindValues) {
            CardPile book = new CardPile();
            for(Card card : getHand().getCards()) {
                if(card.getFaceValue().equals(value)) {
                    book.addCardToPile(card);
                }
            }
            books.add(book);
            for(Card card : book.getCards()) {
                getHand().removeCard(card);
            }
        }

        return fourOfAKindValues.size();
    }

    public void goFish(Card card) {
        addCardToHand(card);
    }

    public ArrayList<CardPile> getBooks() {
        return books;
    }
}
