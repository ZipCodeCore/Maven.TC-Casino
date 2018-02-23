package io.zipcoder.casino.core;

import io.zipcoder.casino.games.blackjack.BlackJack;
import io.zipcoder.casino.games.ceelo.CeeLoGamble;
import io.zipcoder.casino.games.crazy8s.CrazyEights;
import io.zipcoder.casino.games.roulette.Roulette;
import io.zipcoder.casino.interfaces.Game;
import io.zipcoder.casino.utils.IOHandler;

public class Casino {
    static int answer;
    private static Player player;
    private static Game currentGameRunning;
    private boolean isPlaying = true;

    public Casino() {
        this.player = player;
        answer = 0;
    }


    public int getAnswer() {

        return answer;
    }

    public void gameLobby() {
        do {
            String prompt =
                            "**** WELCOME TO HIGH ROLLERS CLUB ****\n" +
                            "*                                    *\n" +
                            "*                                    *\n" +
                            "* Here's 500 chips as a welcome gift!*\n" +
                            "*              ($2500)               *\n" +
                            "*                                    *\n" +
                            "**************************************\n" +
                            "*                                    *\n" +
                            "*       Please choose a game:        *\n" +
                            "*       1. Black Jack                *\n" +
                            "*       2. Crazy Eights              *\n" +
                            "*       3. CeeLo                     *\n" +
                            "*       4. Roulette                  *\n" +
                            "*                                    *\n" +
                            "*       PRESS 5 TO EXIT              *\n" +
                            "*                                    *\n" +
                            "**************************************\n";
            answer = IOHandler.promptForIntWithMessage(prompt);

                changeGameState(answer).play(player);
        }
        while (isPlaying);
    }

    public void enter() {

        gameLobby();
    }

    public Game changeGameState(int answer) {

            switch (answer) {
                case 1:
//                    currentGameRunning = new BlackJack();
                    break;
                case 2:
                    currentGameRunning = new CrazyEights();
                    break;
                case 3:
//                    currentGameRunning = new CeeLoGamble();
                    break;
                case 4:
//                    currentGameRunning = new Roulette();
                    break;
                case 5:
                    isPlaying = false;
            }
        return currentGameRunning;
    }

}

