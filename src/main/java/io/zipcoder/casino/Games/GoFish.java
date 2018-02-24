package io.zipcoder.casino.Games;

import io.zipcoder.casino.Casino;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Deck;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.Players.Player;

import java.util.*;

public class GoFish implements Game {
    Queue<Card> stockPile;
    private List<Card> cardHand;
    ArrayList<Player> players;

    public void startGame(){}

    public void endGame(){}

    public void play() {
        Player rootPlayer = new Player("Bob", 45, 100);
        Player goFishPlayer1 = new GoFishPlayer(rootPlayer);

        cardHand = new ArrayList<Card>();

        players = new ArrayList<Player>();
        players.add(rootPlayer);
        players.add(goFishPlayer1);

        Deck deck = new Deck();
        deck.shuffleDeck();



        //while(goFishPlayer1.getNumPairs())
    }

    public Queue<Card> buildStockPile = new Queue<Card>() {
        public boolean add(Card card) {
            return false;
        }

        public boolean offer(Card card) {
            return false;
        }

        public Card remove() {
            return null;
        }

        public Card poll() {
            return null;
        }

        public Card element() {
            return null;
        }

        public Card peek() {
            return null;
        }

        public int size() {
            return 0;
        }

        public boolean isEmpty() {
            return false;
        }

        public boolean contains(Object o) {
            return false;
        }

        public Iterator<Card> iterator() {
            return null;
        }

        public Object[] toArray() {
            return new Object[0];
        }

        public <T> T[] toArray(T[] a) {
            return null;
        }

        public boolean remove(Object o) {
            return false;
        }

        public boolean containsAll(Collection<?> c) {
            return false;
        }

        public boolean addAll(Collection<? extends Card> c) {
            return false;
        }

        public boolean removeAll(Collection<?> c) {
            return false;
        }

        public boolean retainAll(Collection<?> c) {
            return false;
        }

        public void clear() {

        }
    };

    public void buildPlayerHand() {

    }

    public void buildComputerHand() {

    }


    public void deal() {
        this.buildPlayerHand();
        this.buildComputerHand();
        //this.buildStockPile();
    }

    public int deckSize() {
        return cardHand.size();
    }


    public String displayCardHand() {
        StringBuilder cardHandBuilder = new StringBuilder();
        for (int i = 0; i < cardHand.size(); i++) {
            cardHandBuilder.append("Card " + (i + 1) + cardHand.get(i) + "\n");
        }

        return cardHandBuilder.toString();
    }

    public boolean isGameOver() {
        return false;
    }


}
