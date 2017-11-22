package io.zipcoder.casino.games.craps;


import io.zipcoder.casino.nuts_n_bolts.User;
import java.util.Random;
import static io.zipcoder.casino.nuts_n_bolts.Input.getPositiveDoubleInput;

public class CrapsConsoleWIP {

    private CrapsWIP game = new CrapsWIP();
    private User player;
    private double mainPotBet;
    private double sidePotBet;
    private boolean pointSet=false;
    private boolean pointMet=false;
    private Random rando=new Random();

    public CrapsConsoleWIP(){
        player=new User("Uncle Bob", 10_000.0);
    }

    public CrapsConsoleWIP(User user){
        player=user;
    }

    public void run(){
        welcomePlayer();
        game.determineFirstRoller();
        while (!pointSet) {//Continue to bet until the roller
                        //throws a point instead of a win/loss.
            initialBet();
            pointSet=resolveInitialThrow(game.initialThrow());
        }
        //Now we're on secondaryThrows
        secondaryBet();
    }

    private void initialBet(){

        if (game.getPlayerTurn())
        {
            playerInitialBets();
        }
        else
        {
            playerInitialBets(generateBotBet());
        }

    }
    private void playerInitialBets() {
        do {
            mainPotBet = getPositiveDoubleInput
                    ("How much would you like to bet? ");
        }while (player.getWallet().getMoney()<mainPotBet);

        game.takeBet(player.getWallet().takeOutMoney(mainPotBet));//player bet
        game.takeBet(mainPotBet);//house bet matches
    }
    private void playerInitialBets(Double betToMatch){
        System.out.println("You have to match "+betToMatch);
        game.takeBet(betToMatch);//house bet to match
        game.takeBet(player.getWallet().takeOutMoney(betToMatch));//player matches bet
        mainPotBet=betToMatch;
    }

    private double generateBotBet(){
        return(rando.nextDouble()*
                (rando.nextInt(player.getWallet().getMoney().intValue()))+1);
    }

    private void secondaryBet(){
        System.out.println("The point is set at "+game.getPoint()+" and side" +
                " bets will be made on "+game.getPair()+". ");
        if (game.getPlayerTurn())
        {
            playerSecondaryBets();
        }
        else
        {
            playerSecondaryBets(generateBotBet());
        }
    }
    private void playerSecondaryBets(){
        do {
            sidePotBet = getPositiveDoubleInput
                    ("How much would you like to bet? ");
        }while (player.getWallet().getMoney()< sidePotBet);

        game.takeSideBet(player.getWallet().takeOutMoney(sidePotBet));//player bet
        game.takeSideBet(sidePotBet);//house bet matches
    }
    private void playerSecondaryBets(Double betToMatch){
        System.out.println("You have to match "+betToMatch);
        game.takeSideBet(betToMatch);//house bet to match
        game.takeSideBet(player.getWallet().takeOutMoney(betToMatch));//player matches bet
        sidePotBet=betToMatch;
    }

    private boolean resolveInitialThrow(int resultOfThrownDice){
        if (resultOfThrownDice!=0){
            //non-Thrower (-1) or thrower (1) wins the mainPotBet
            resolveInitialThrowBet(resultOfThrownDice);
            return false;
        }
        //point was set and we move onto the
        // next step in the game
        return true;
    }
    private void resolveInitialThrowBet(int a){
        if (a==1){
            if (game.getPlayerTurn()){//If the thrower is the player and they won, pay them
                player.getWallet().addMoney(game.emptyPot());
                //Player wins the pot and we go back to bet again
            }
            else//If the bot is the thrower, empty the pot
            {
                mainPotBet=game.emptyPot();//mainPotBet will be overwritten in the next
                                //function call, so we can use it here to catch this
                                //method's return
            }
        }
        else {
            if (game.getPlayerTurn()) {//If the thrower is the player and they lost, empty the pot and bet again
                mainPotBet=game.emptyPot();
            }
            else{//if the bot is the thrower and they lost, pay the player
                player.getWallet().addMoney(game.emptyPot());
            }
        }
    }

    private void welcomePlayer(){
        System.out.println("Hello, "+player.getName()+". Welcome to the "+game.getClass().getSimpleName()+" table.");
    }

}
