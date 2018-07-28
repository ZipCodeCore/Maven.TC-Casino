package io.zipcoder.casino;

import java.util.*;

import io.zipcoder.casino.Card.*;

public class CompPlay {


    private static Random rand = new Random();
    private static Map<GoFishPlayer, Set<Rank>> playerCards = new HashMap<>();


    public static Integer makeBet(BlackJackGambler player) {
        return player.placeBet(250);
    }

    public static String hitOrStay(BlackJackGambler player) {
        if (player.getClass().getSimpleName().equals("Dealer"))
            return dealerHitOrStay(player);
        else return basicHitOrStay(player);
    }

    private static String dealerHitOrStay(BlackJackGambler player) {
        if (player.getHandTotal() >= 17)
            return "Stay";
        else return "Hit";
    }

    private static String basicHitOrStay(BlackJackGambler player) {
        if (player.getHandTotal() < 12) {
            return "Hit";
        }
        if (player.getHandTotal() >= 18)
            return "Stay";
        else {
            int rand = new Random().nextInt(10) + 1;
            if (rand < 4)
                return "Hit";
            else return "Stay";
        }
    }

    public static String getPlayerCards() {
        String cards = "";
        for (GoFishPlayer p : playerCards.keySet()) {
            cards += playerCards.get(p) + "\n";
        }
        return cards;
    }

    public static void setUpPlayerCards(GoFishPlayer player) {
        Set card = new HashSet<Rank>();
        playerCards.put(player, card);
    }

    public static void clearPlayerCards() {
        playerCards.clear();
    }

    public static void addRankToPlayer(GoFishPlayer player, Rank cardRank) {
        playerCards.get(player).add(cardRank);
    }


    public static void removeRankFromPlayer(GoFishPlayer player, Rank cardRank) {
        playerCards.get(player).remove(cardRank);
    }

    public static Rank chooseRank(GoFishPlayer player) {
        Rank cardRank=null;
        for (Card card : player.getHand()) {
            for (GoFishPlayer otherPlayer : playerCards.keySet()) {
                if (playerCards.get(otherPlayer).contains(card.getRank())&&!player.equals(otherPlayer)) {
                    cardRank = card.getRank();
                    return cardRank;
                }
            }
        }
        cardRank = player.getHand().get(player.getHand().size() - 1).getRank();
        return cardRank;
    }

    public static GoFishPlayer choosePlayer(GoFishPlayer player, Rank cardRank) {
        for (GoFishPlayer p : playerCards.keySet()) {
            if (playerCards.get(p).contains(cardRank)&&!player.equals(p)) {
                return p;
            }
        }
        GoFishPlayer[] arr = playerCards.keySet().stream().toArray(GoFishPlayer[]::new);
        GoFishPlayer otherPlayer = null;
        do {
            otherPlayer = arr[rand.nextInt(arr.length)];
        }
        while (otherPlayer.equals(player)||otherPlayer.getHand().size()==0);
        return otherPlayer;
    }

}
