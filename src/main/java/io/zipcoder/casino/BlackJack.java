package io.zipcoder.casino;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BlackJack extends CardGames<BlackJackGambler> implements Gamble<BlackJackGambler> {
    private Dealer dealer;
    private String playAgain = "";
    private Map<BlackJackGambler, Integer> playerWagers = new HashMap<BlackJackGambler, Integer>();

    public void play(BlackJackGambler user) {
        gameSetUp(user);
        do {
            if (getRemainingDeckCards() / getPlayers().size() < 52)
                loadDecks(8);
            System.out.println(user.getName() + " Chips: " + user.getChipCount() + "\n");
            for (BlackJackGambler player : getPlayers()) {
                Integer bet = takeBet(player);
                playerBet(player, bet);
            }

            addPlayer(dealer);
            dealCards(2);
            removePlayer(dealer);

            System.out.println(dealer.showOneCard());
            for (BlackJackGambler player : getPlayers())
                System.out.println(player.showHand());

            for (BlackJackGambler player : getPlayers())
                hitOrStay(player);

            System.out.println("Dealers Cards: " + dealer.showHand() + "\n");

            hitOrStay(dealer);
            checkForWinners();

            if (user.getChipCount() == 0) {
                System.out.println("Your are out of chips, returning to lobby");
                playAgain = "no";
            } else
                playAgain = Console.getStringInput("Play again?");

            resetHands();
            resetBets();
            removeZeroChipPlayers();
        } while ("yes".equalsIgnoreCase(playAgain));

    }

    @Override
    public void gameSetUp(BlackJackGambler user) {
        dealer = new Dealer();
        addPlayer(user);
        loadDecks(8);
        int numberOfPlayers = new Random().nextInt(6) + 1;
        addAIPlayers(numberOfPlayers);
        resetBets();
    }

    @Override
    public void addAIPlayers(int playersToAdd) {
        for (int i = 1; i <= playersToAdd; i++)
            getPlayers().add(new BlackJackGambler(new Player("Computer" + i, 0, false), 3000));
    }

    @Override
    public Integer takeBet(BlackJackGambler player) {
        Integer bet;
        if (player.isPerson()) {
            bet = Console.getIntegerInput("Place your bet");
            bet = player.placeBet(bet);
        } else bet = CompPlay.makeBet(player);

        return bet;
    }

    private void playerBet(BlackJackGambler player, Integer amount) {
        playerWagers.put(player, amount);
    }

    private void hitOrStay(BlackJackGambler player) {
        String userChoice = "";

        while (!userChoice.equalsIgnoreCase("Stay") && !isBust(player)) {
            if (player.isPerson())
                userChoice = Console.getStringInput("Hit or Stay?");
            else userChoice = CompPlay.hitOrStay(player);

            if (userChoice.equalsIgnoreCase("Hit")) {
                System.out.println(player.getName() + ": Hit");
                Card card = getDeckCard();
                player.addCardToHand(card);
                System.out.println(card + " New Total: " + player.getHandTotal() + "\n");
            } else if (userChoice.equalsIgnoreCase("Stay"))
                System.out.println(player.getName() + ": Stay\n");
        }

        if (isBust(player))
            System.out.println(player.getName() + " went over: " + player.getHand() + "\n");
    }

    private boolean isBust(BlackJackGambler player) {
        if (player.getHandTotal() > 21) {
            return true;
        }
        return false;
    }

    private void checkForWinners() {
        for (BlackJackGambler player : getPlayers()) {
            int multiplier = 0;
            if (!isBust(dealer) && !isBust(player))
                multiplier = payoutMultiplier(player);
            else if (!isBust(player))
                multiplier = 2;
            payoutWinnings(player, multiplier);
        }
    }

    private int payoutMultiplier(BlackJackGambler player) {
        if (player.getHandTotal() > dealer.getHandTotal()) {
            return 2;
        } else if (player.getHandTotal() == dealer.getHandTotal())
            return 1;
        return 0;
    }

    private boolean checkForBlackJack(BlackJackGambler player) {
        if (player.getHandTotal() == 21 && player.getHand().size() == 2)
            return true;
        return false;
    }

    private void payoutWinnings(BlackJackGambler player, double multiplier) {
        if (checkForBlackJack(player))
            multiplier += 0.5;
        Integer winnings = (int) (playerWagers.get(player).doubleValue() * multiplier);
        System.out.println(player.showHand());
        System.out.println(" Winnings: " + winnings + "\n");
        player.addChips(winnings);
    }

    private void removeZeroChipPlayers() {
        ArrayList<BlackJackGambler> playersToRemove = new ArrayList<>();
        for (BlackJackGambler player : getPlayers())
            if (player.getChipCount() == 0 && !player.isPerson()) {
                System.out.println(player.getName() + " ran out of chips, now leaving.");
                playersToRemove.add(player);
            }
        getPlayers().removeAll(playersToRemove);
    }


    private void resetHands() {
        for (BlackJackGambler player : getPlayers())
            player.clearHand();
        dealer.resetHand();
    }

    @Override
    public void resetBets() {
        for (BlackJackGambler player : getPlayers())
            playerWagers.put(player, 0);
    }

}
