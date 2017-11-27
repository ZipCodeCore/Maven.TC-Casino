package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.zipcoder.casino.Card.*;


public class GoFishPlayer extends CardPlayer {

    private ArrayList<Rank> completedBooks = new ArrayList<>();
    private int books = 0;
    private Map<Rank, Integer> cardMap;

    public GoFishPlayer(Player player) {
        super(player);
        cardMap = new HashMap<Rank, Integer>();
    }

    private void mapNewCard(Card card) {
        Integer val = cardMap.getOrDefault(card.getRank(), 0);
        cardMap.put(card.getRank(), val + 1);
    }

    private void mapCardRemoved(Rank rank) {
        Integer val = cardMap.get(rank);
        cardMap.put(rank, val - 1);
    }

    public boolean checkForCard(Rank rank) {
        if (cardMap.getOrDefault(rank, 0) != 0)
            return true;
        return false;
    }

    public ArrayList<Card> giveCards(Rank rank) {

        ArrayList<Card> cards = new ArrayList<>();
        while (checkForCard(rank)) {
            cards.add(removeCard(rank));
            mapCardRemoved(rank);
        }
        return cards;
    }

    public void removeBooks() {
        for (Rank rank : cardMap.keySet())
            if (cardMap.get(rank) == 4) {
                CompPlay.removeRankFromPlayer(this, rank);
                addCompletedBooks(rank);
                giveCards(rank);
                books++;
                System.out.println(getName() + " Completed Book: " + rank);
            }
    }

    public int getBookCount() {
        return books;
    }

    private void addCompletedBooks(Rank rank) {
        completedBooks.add(rank);
    }

    public String completedBooksToString() {
        String complete = "|";
        for (Rank rank : completedBooks)
            complete += " {" + rank + "} |";
        return complete;
    }

    public int getPointTotal(){
        int points=0;
        for (Rank rank : completedBooks)
            points+=rank.getValue();
        return points;
    }

    @Override
    public void addCardToHand(Card card) {
        mapNewCard(card);
        super.addCardToHand(card);
    }

}
