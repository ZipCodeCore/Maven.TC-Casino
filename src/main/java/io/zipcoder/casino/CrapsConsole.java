package io.zipcoder.casino;

import java.util.ArrayList;

public class CrapsConsole extends Console {

    private String nameOfGame = "Craps";

    private Craps game = new Craps();
    private CrapsPlayer currentPlayer;

    @Override
    public void start() {
        setUpGame();
        playRoundsUntilAllPlayersCashOut(game.getPlayers());
    }

    @Override
    public void setUpGame() {
        System.out.printf("Welcome to %s\n", game.getClass().getSimpleName());
        int numPlayers = getNumPlayers(game.MIN_NUMBER_OF_PLAYERS, game.MAX_NUMBER_OF_PLAYERS);
        ArrayList<String> playerNames = getPlayerNames(numPlayers);
        ArrayList<Player<Craps>> players = new ArrayList<>();
        for(String name : playerNames) {
            CrapsPlayer player = new CrapsPlayer(name);
            players.add(player);
        }
        game.addPlayers(players);
    }

    @Override
    public void playRound() {

    }

    public void comeOutRoll() {
        // first roll of game
        // current player is required to make a bet - either pass or don't pass
        // any other player may also make a bet, but may also wait until after the come out roll
        // if roll is 2, 3, 12 the pass bets lose and the don't pass bets win
        // if roll is 7, 11 the pass bets win and the don't pass bets lose
        // if above rolls happen, that is the end of the round and bets are paid out
        // else go on to establish point and play continues until point is rolled again, or 7
        // if roll is 4, 5, 6, 8, 9, 10 bets stay on either pass or don't pass
        // additional players may not bet until it is their turn - house rules!
    }

    public void rollForPoint() {

    }

    @Override
    public String getNameOfGame() {
        return nameOfGame;
    }
}
