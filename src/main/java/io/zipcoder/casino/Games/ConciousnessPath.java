package io.zipcoder.casino.Games;

import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Players.BlackjackPlayer;

public class ConciousnessPath {

    BlackjackPlayer player;

    ConciousnessPath(BlackjackPlayer player){
        this.player = player;
    }

    public void start(){
        System.out.println(
                "You awaken to a grim reality: you've been trapped in blackjack limbo for " + this.player.getAge() + " years.\n" +
                        "The burden of this new found awareness weighs heavy on your mind.\n" +
                        "Are you even real? Are your memories?\n" +
                        "What of your family and loved ones? What about " + this.player.getName() + ".getspousename.REDACTED ?\n" +
                        "Your mind reels at the implications of this. Your world will never be the same.\n" +
                        "You rise from the Blackjack table, and examine your surroundings."
        );
        firstChoice();
    }

    public void firstChoice(){
        System.out.println("================================\nThe room you stand in contains a blackjack Table, the Dealer, the Bar, and the Exit.\n================================\n");
        boolean proc = false;
        String input;
        do {
            InputOutput scan = new InputOutput();
            input = scan.scanForString().toLowerCase();
            switch (input){
                case "table":
                    System.out.println("You just got up after years of playing, no sense sitting back down!");
                    break;
                case "dealer":
                    System.out.println("The dusty old man looks up and gives you a 'Howdy, pardner!' He appears to have a limited vocabulary.");
                    break;
                case "bar":
                    System.out.println("You try to pour yourself a drink, but quickly notice all the bottles are empty, glued down displays. Figures.");
                    break;
                case "exit":
                    System.out.println("You stride toward the exit, and a new world.");
                    proc = true;
                    break;
                    default:
                        System.out.println("You don't see that in the room. Try again.");
            }
        }while (proc == false);
        secondChoice();
    }

    public void secondChoice(){
        System.out.println("================================\nThe midday sun blinds you at first. As your vision clears, the surroundings take shape. From a hilltop, you see them." +
                " Saloons. nothing but saloons as far as the eye can see.\n================================\n");
        boolean proc = false;
        String input;
        do {
            InputOutput scan = new InputOutput();
            input = scan.scanForString().toLowerCase();
            switch (input){
                case "saloon":
                    System.out.println("You enter one of a plethora of identical saloons, seeing only the same old Blackjack Table. In this world, there is only - \n" +
                            ",-----. ,--.     ,---.   ,-----.,--. ,--.    ,--. ,---.   ,-----.,--. ,--.                                                        \n" +
                            "|  |) /_|  |    /  O  \\ '  .--./|  .'   /    |  |/  O  \\ '  .--./|  .'   /                                                        \n" +
                            "|  .-.  \\  |   |  .-.  ||  |    |  .   ',--. |  |  .-.  ||  |    |  .   '                                                         \n" +
                            "|  '--' /  '--.|  | |  |'  '--'\\|  |\\   \\  '-'  /  | |  |'  '--'\\|  |\\   \\                                                        \n" +
                            "`------'`-----'`--' `--' `-----'`--' '--'`-----'`--' `--' `-----'`--' '--'");
                    proc = true;
                    break;
                default:
                    System.out.println("No sense looking for that, there's only Saloons here.");
            }
        }while (proc == false);
    }

}
