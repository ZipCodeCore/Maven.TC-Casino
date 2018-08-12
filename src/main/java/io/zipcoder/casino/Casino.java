package io.zipcoder.casino;


public class Casino {

    private enum Games {BLACKJACK, CRAPS, GOFISH, EXIT}

    private String playerName;
    private Player player;
    private CasinoCage casinoCage = new CasinoCage();

    public void start() {

        playerName = Console.getStringInput("Please enter your name");
        player = new Player(playerName, 10000, true);
        String userInput = "";
        do {
            for (Games game : Games.values())
                System.out.print(" {" + game + "} ");
            try {
                userInput = Console.getStringInput("\nEnter the name of the game you would like to play: ");
                Games gameSelection = Games.valueOf(userInput);
                gameSelection(gameSelection);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Choice");
            }
        } while (!"Exit".equalsIgnoreCase(userInput));


    }

    private void gameSelection(Games userInput) {

        switch (userInput) {
            case CRAPS:
                playCraps();
                break;
            case BLACKJACK:
                playBlackJack();
                break;
            case GOFISH:
                playGoFish();
                break;
            case EXIT:
                System.exit(0);
                break;

        }
    }

    private void playCraps() {
        Craps craps = new Craps();
        CrapsPlayer gambler;

        Integer chipReq = Console.getIntegerInput("How many chips would you like to purchase? ($" + player.getCash() + " avail.)");
        chipReq = player.withdrawalCash(chipReq);
        if (chipReq > 0) {
            Integer chips = casinoCage.payoutChips(chipReq);
            gambler = new CrapsPlayer(player, chips);
            craps.play(gambler);
            chips=gambler.tradeInChips();
            Integer winnings=casinoCage.payoutCash(chips);
            player.addCash(winnings);
        } else System.out.println("Sorry invalid amount");

    }

    private void playBlackJack() {
        BlackJack blackJack = new BlackJack();
        BlackJackGambler gambler;
        Integer chipReq = Console.getIntegerInput("How many chips would you like to purchase? ($" + player.getCash() + " avail.)");
        chipReq = player.withdrawalCash(chipReq);
        if (chipReq > 0) {
            Integer chips = casinoCage.payoutChips(chipReq);
            gambler = new BlackJackGambler(player, chips);
            blackJack.play(gambler);
            chips=gambler.tradeInChips();
            Integer winnings=casinoCage.payoutCash(chips);
            player.addCash(winnings);
        } else System.out.println("Sorry invalid amount");


    }

    private void playGoFish() {
        GoFish goFish = new GoFish();
        GoFishPlayer goFishPlayer = new GoFishPlayer(player);
        goFish.play(goFishPlayer);
    }

    private class CasinoCage {
        Integer bankRoll = 100000000;


        public Integer payoutChips(Integer chipReq) {
            if (chipReq < bankRoll) {
                bankRoll += chipReq;
            }
            return chipReq;
        }

        public Integer payoutCash(Integer chipCount) {
            bankRoll-=chipCount;
            return chipCount;
        }
    }
}
