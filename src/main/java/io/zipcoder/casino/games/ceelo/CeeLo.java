//package io.zipcoder.casino.games.ceelo;
//
//import io.zipcoder.casino.core.Player;
//import io.zipcoder.casino.games.Die;
//import io.zipcoder.casino.interfaces.Game;
//import io.zipcoder.casino.utils.Dice;
//import io.zipcoder.casino.utils.IOHandler;
//
//import java.util.Arrays;
//
///**
// * filename:
// * project: casino
// * author: https://github.com/vvmk
// * date: 2/23/18
// */
//public class CeeLo implements Game {
//    private static final String fRULES_PATH = "ceelo.rules.txt";
//    private static final String fTAKE_BET_MSG = "Place your bet";
//    private static final String fPLAY_AGAIN_MSG = "Press \"Enter\" to play again...\nyou can also type \"rules\" or \"back\"";
//    private static final String fPLAYER_WINS_MSG = "You Won!";
//    private static final String fPLAYER_TIE_MSG = "Push";
//    private static final String fPLAYER_LOSE_MSG = "You're a Loser!";
//
//    private int takeBet() {
//        return IOHandler.promptForIntWithMessage(fTAKE_BET_MSG);
//    }
//
//    private long decidePayout(CeeLoGamble bet) {
//        long payout;
//
//        displayBankerRolls();
//        int bankerPoint = rollForPoint();
//        displayBankerPoint(bankerPoint);
//
//        if (bankerPoint == 6) {
//            displayLoseMessage(bet.lose());
//            return bet.lose();
//        } else if (bankerPoint == 1) {
//            displayWinMessage(bet.win());
//            return bet.win();
//        }
//
//        displayPlayerRolls();
//        int playerPoint = rollForPoint();
//        displayPlayerPoint(playerPoint);
//
//        if (bankerPoint < playerPoint) {
//            payout = bet.win();
//            displayWinMessage(payout);
//        } else if (bankerPoint == playerPoint) {
//            payout = bet.push();
//            displayPushMessage(payout);
//        } else {
//            payout = bet.lose();
//            displayLoseMessage(payout);
//        }
//
//        return payout;
//    }
//
//    protected int rollForPoint() {
//        int point;
//        do {
//            Die d6 = new Die(6);
//            int[] rolls = d6.roll(3);
//            point = getPoint(d6, rolls);
//            displayRoll(rolls);
//        } while (point < 1);
//        return point;
//    }
//
//    protected int getPoint(Die die, int[] rolls) {
//        if (Dice.containsHighStraight(die, rolls) || Dice.containsHighStraight(die, rolls))
//            return 6;
//
//        if (Dice.containsLowStraight(die, rolls))
//            return 1;
//
//        return Dice.getCeeloPoint(rolls);
//    }
//
//    @Override
//    public void play(Player player) {
//        runWelcome();
//        boolean playAgain;
//        do {
//            displayPlayerHUD(player);
//            CeeLoGamble bet = new CeeLoGamble(player.betChips(takeBet()));
//            player.addChips(decidePayout(bet));
//            playAgain = setPlayAgain();
//        } while (playAgain && player.getBalance() > 0);
//    }
//
//    private void displayRoll(int[] rolls) {
//        IOHandler.printMessage(Arrays.toString(rolls));
//    }
//
//    private void displayLoseMessage(long payout) {
//        displayStarLine();
//        IOHandler.printMessage(String.format("%s\n\tpayout: %d chips", fPLAYER_LOSE_MSG, payout));
//        displayStarLine();
//    }
//
//    private void displayWinMessage(long payout) {
//        displayStarLine();
//        IOHandler.printMessage(String.format("%s\n\tpayout: %d chips", fPLAYER_WINS_MSG, payout));
//        displayStarLine();
//    }
//
//    private void displayPushMessage(long payout) {
//        displayStarLine();
//        IOHandler.printMessage(String.format("%s\n\tpayout: %d chips", fPLAYER_TIE_MSG, payout));
//        displayStarLine();
//    }
//
//    private void displayBankerRolls() {
//        IOHandler.printMessage("Banker rolling...");
//    }
//
//    private void displayPlayerRolls() {
//        IOHandler.printMessage("Player Rolling...");
//    }
//
//    private void displayBankerPoint(int point) {
//        IOHandler.printMessage("Banker scores: " + point);
//    }
//
//    private void displayPlayerPoint(int point) {
//        IOHandler.printMessage("Player scores: " + point);
//    }
//
//    private void displayPlayerHUD(Player player) {
//        IOHandler.printMessage("Chip Balance: " + player.getBalance());
//    }
//
//    private void displayStarLine() {
//        IOHandler.printMessage("********************************");
//    }
//
//    private boolean setPlayAgain() {
//        String in = IOHandler.promptForStringWithMessage(fPLAY_AGAIN_MSG);
//        return !in.equals("back");
//    }
//
//    @Override
//    public void quitGame() {
//        // not sure what i need to do here actually. clean up, say goodbye, idk
//    }
//
//    @Override
//    public void runWelcome() {
//        IOHandler.printMessage(getRules());
//    }
//
//    @Override
//    public String getRules() {
//        return IOHandler.getMessageFromFile(fRULES_PATH);
//    }
//}
