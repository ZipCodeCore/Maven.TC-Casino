package io.zipcoder.casino;

public class Roulette {
    private Player player;
    private RouletteBoard rouletteBoard;
    private RoulettePrompts prompts;

    public Roulette(Player player){
        this.player = player;
        rouletteBoard = new RouletteBoard();
        prompts = new RoulettePrompts();
    }

    public void play(Player player){

    }


}
