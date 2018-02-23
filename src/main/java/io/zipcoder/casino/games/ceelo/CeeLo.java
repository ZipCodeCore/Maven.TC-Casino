package io.zipcoder.casino.games.ceelo;

import io.zipcoder.casino.core.Player;
import io.zipcoder.casino.interfaces.Game;
import io.zipcoder.casino.utils.IOHandler;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/23/18
 */
public class CeeLo implements Game {
    private static final String fRULES_PATH = "ceelo.rules.txt";
    private static final String fTAKE_BET_MSG = "Place your bet";
    private static final String fPLAY_AGAIN_MSG = "Press \"Enter\" to play again...\nyou can also type \"rules\" or \"back\"";
    private Player player;

    private int takeBet() {
        return IOHandler.promptForIntWithMessage(fTAKE_BET_MSG);
    }

    private void playRound() {
        CeeLoGamble bet = new CeeLoGamble(player.betChips((long)takeBet()));
        long payout;

        int bankerPoint = getBankerPoint();
        int playerPoint = getPlayerPoint();

        if (bankerPoint < playerPoint)
            payout = bet.win();
        else if (bankerPoint == playerPoint)
            payout = bet.push();
        else
            payout = bet.lose();

        player.addChips(payout);
    }

    protected int getBankerPoint() {
        return -1;
    }

    protected int getPlayerPoint() {
        return -1;
    }

    private boolean setPlayAgain() {
        String in = IOHandler.promptForStringWithMessage(fPLAY_AGAIN_MSG);
        return in.equals("back");
    }

    @Override
    public void play(Player player) {
        this.player = player;
        runWelcome();
        boolean playAgain;
        do {
            playRound();
            playAgain = setPlayAgain();
        } while(playAgain);
    }

    @Override
    public void quitGame() {
        // not sure what i need to do here actually. clean up, say goodbye, idk
    }

    @Override
    public void runWelcome() {
        IOHandler.printMessage(getRules());
    }

    @Override
    public String getRules() {
        return IOHandler.getMessageFromFile(fRULES_PATH);
    }
}
