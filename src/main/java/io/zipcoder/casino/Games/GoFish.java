package io.zipcoder.casino.Games;

import io.zipcoder.casino.Casino;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.Players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class GoFish {
    Queue<Card> stockPile;



    public void start() {
        Player rootPlayer = new Player("Bob", 45, 100.00);
        Player goFishPlayer1 = new GoFishPlayer(rootPlayer);

        CardGame cardGame = new CardGame() {
            @Override
            public void generateDeck() {
                super.generateDeck();
            }

            @Override
            public int getNumberOfPlayers() {
                return super.getNumberOfPlayers();
            }

            @Override
            public void setNumberOfPlayers(int numberOfPlayers) {
                super.setNumberOfPlayers(numberOfPlayers);
            }

            @Override
            public int getMaxNumberOfPlayers() {
                return super.getMaxNumberOfPlayers();
            }

            @Override
            public void setMaxNumberOfPlayers(int maxNumberOfPlayers) {
                super.setMaxNumberOfPlayers(maxNumberOfPlayers);
            }

            @Override
            public ArrayList<Card> getDeck() {
                return super.getDeck();
            }

            @Override
            public void shuffleDeck() {
                super.shuffleDeck();
            }
        };

    }

    public Queue<Card> getStockPile = new Queue<Card>() {
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

    public void deal() {

    }

    public String displayCardHand() {
        return "";
    }

    public boolean isGameOver() {
        return false;
    }


}
