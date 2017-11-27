package io.zipcoder.casino.casino;

import io.zipcoder.casino.games.craps.CrapsConsole;
import io.zipcoder.casino.nuts_n_bolts.Menu;

public class CasinoMenu extends Menu{

    public static final CasinoMenu INSTANCE = new CasinoMenu();

    enum CasinoMenuOptions {CRAPS, GOFISH, BLACKJACK, EXIT}

    public CasinoMenu(){
        super(CasinoMenuOptions.values());
    }
    
    @Override
    public void selectOption(String userInput) {
        switch(CasinoMenuOptions.valueOf(userInput)){
            case EXIT:
                Casino.getInstance().exitCasino();
            case CRAPS:{
                CrapsConsole craps = new CrapsConsole(/*PassedUserOptional*/);
                craps.run();
                break;
            }
            case GOFISH:
//                goFishMenu();
                break;
            case BLACKJACK:
//                blackJackMenu();
                break;
        }
    }

    /*
    private void crapsMenu() {
        CrapsMenu crapsMenu = CrapsMenu.INSTANCE;
        crapsMenu.display();
    }

    private void goFishMenu() {
        GoFishMenu goFishMenu = GoFishMenu.INSTANCE;
        goFishMenu.display();
    }

    private void blackJackMenu() {
        BlackJackMenu blackJackMenu = BlackJackMenu.INSTANCE;
        blackJackMenu.display();
    }
*/


}
