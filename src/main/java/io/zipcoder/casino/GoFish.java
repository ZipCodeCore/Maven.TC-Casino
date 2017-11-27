package io.zipcoder.casino;

import io.zipcoder.casino.Card.*;

import java.util.ArrayList;

public class GoFish extends CardGames<GoFishPlayer> {

    public void play(GoFishPlayer user) {

        gameSetUp(user);

        while (booksRemaining() > 0) {
            System.out.println("Books remaining: " + booksRemaining());
            booksFound();
            System.out.println("Your Hand: " + user.handToString());
            Rank cardRank = null;
            GoFishPlayer otherPlayer = null;
            for (GoFishPlayer player : getPlayers()) {
                if (player.getHand().size() == 0)
                    continue;
                cardRank = playerCardChoice(player);
                otherPlayer = chooseOtherPlayer(player, cardRank);
                System.out.println(player.getName() + " asks " + otherPlayer.getName() + " for any " + cardRank);
                if (goFish(player, otherPlayer, cardRank) && getRemainingDeckCards() > 0) {
                    Card card = getDeckCard();
                    player.addCardToHand(card);
                }
                player.removeBooks();
            }
        }

        findWinner();
        CompPlay.clearPlayerCards();
        Console.getStringInput("Game Over, Press any key to return to the lobby.");
    }

    @Override
    public void gameSetUp(GoFishPlayer user) {
        addPlayer(user);
        loadDecks(1);

        int numberOfPlayers = Console.getIntegerInput("How many other players would you like to play with? ");
        addAIPlayers(numberOfPlayers);
        dealCards(5);
        for (GoFishPlayer player : getPlayers())
            CompPlay.setUpPlayerCards(player);
    }
    @Override
    public void addAIPlayers(int playersToAdd) {
        if(playersToAdd==0)
            playersToAdd=1;
        for (int i = 1; i <= playersToAdd; i++)
            addPlayer(new GoFishPlayer(new Player("Computer" + i, 0, false)));
    }

    private boolean goFish(GoFishPlayer player, GoFishPlayer otherPlayer, Rank cardRank) {
        CompPlay.addRankToPlayer(player, cardRank);
        if (otherPlayer.checkForCard(cardRank)) {

            ArrayList<Card> cardsTaken = otherPlayer.giveCards(cardRank);
            CompPlay.removeRankFromPlayer(otherPlayer, cardRank);
            for (Card card : cardsTaken)
                player.addCardToHand(card);
            System.out.println("Found " + cardsTaken.size() + " " + cardRank);


            Console.getStringInput("press enter to continue");
            return false;
        } else {
            System.out.println("no matches found");
            Console.getStringInput("press enter to continue");
            return true;
        }
    }

    private GoFishPlayer chooseOtherPlayer(GoFishPlayer player, Rank cardRank) {
        Integer playerIndex;
        GoFishPlayer chosenPlayer;
        if (player.isPerson()) {
            printPlayers();
            do {
                playerIndex = Console.getIntegerInput("\nWho has your card? ");
                chosenPlayer = getPlayer(playerIndex);
            } while (chosenPlayer == null);
        } else chosenPlayer = CompPlay.choosePlayer(player, cardRank);
        return chosenPlayer;
    }


    private Rank playerCardChoice(GoFishPlayer player) {
        Rank cardRank;
        if (player.isPerson()) {
            do {
                cardRank = Console.getRankInput("What card are you looking for?");
            } while (!player.checkForCard(cardRank));
        } else cardRank = CompPlay.chooseRank(player);
        return cardRank;
    }

    private void booksFound() {
        for (GoFishPlayer player : getPlayers())
            System.out.println(player.getName() + " Completed Books: " + player.completedBooksToString());
    }

    private int booksRemaining() {
        int booksMade = 0;
        for (GoFishPlayer player : getPlayers())
            booksMade += player.getBookCount();
        return 13 - booksMade;
    }

    private void printPlayers() {
        for (int i = 1; i < getPlayers().size(); i++)
            System.out.print(" " + i + ") " + getPlayer(i).getName());
    }

    private void findWinner() {
        GoFishPlayer winner = null;
        int topScore = 0;
        for (GoFishPlayer player : getPlayers()) {
            if (player.getPointTotal() > topScore) {
                winner = player;
                topScore = player.getPointTotal();
            }
            System.out.println(player.getName() + ": " + player.getPointTotal() + " points");
        }
        System.out.println("Winner: " + winner.getName() + " with " + topScore + " points!");
    }
}
