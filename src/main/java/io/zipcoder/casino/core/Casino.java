package io.zipcoder.casino.core;

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
            String prompt = "Welcome to High Rollers Club!\n" +
                    "As a welcome gift, here's 500 chips ($2500)\n" +
                    "Please choose a game to play\n(Enter a number for your selection)\n\n" +
                    "\t1. Black Jack\n\t2. Crazy 8's\n\t3. Ceelo\n\t4. Roulette\n\t5. EXIT";

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

