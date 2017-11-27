package io.zipcoder.casino.games.gofish;

import io.zipcoder.casino.casino.Casino;
import io.zipcoder.casino.games.CardGame;
import io.zipcoder.casino.nuts_n_bolts.Menu;

public class GoFishMenu extends Menu {

    enum GoFishMenuOptions {PLAY, BACK}
    public static final GoFishMenu INSTANCE = new GoFishMenu();
    GoFish goFish = new GoFish(Casino.getInstance().getUser());

    public GoFishMenu() {
        super(GoFishMenuOptions.values());
    }

    @Override
    public void selectOption(String userInput) {
        switch(GoFishMenuOptions.valueOf(userInput)){
            case BACK:
                break;
            case PLAY:
                goFish.run();
                break;
//            case SETPLAYERS:
//                goFishMenu();
//                break;
//            case SETRULES:
//                blackJackMenu();
//                break;
        }
    }
}
