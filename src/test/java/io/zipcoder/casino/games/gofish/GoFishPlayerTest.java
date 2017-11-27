package io.zipcoder.casino.games.gofish;

import io.zipcoder.casino.nuts_n_bolts.User;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingCard;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingSuit;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingValue;
import org.junit.Assert;
import org.junit.Test;

public class GoFishPlayerTest {



    @Test
    public void creationAndGetterTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);
        GoFish.GoFishPlayer player = goFish.getHumanPlayer();

        Assert.assertEquals(user, player.getUser());
        Assert.assertNull(player.getAskedValue());
    }

    @Test
    public void drawCardPutsInHandTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);
        GoFish.GoFishPlayer player = goFish.getHumanPlayer();

        Assert.assertTrue(player.getHand().isHandEmpty());
        player.drawCard();
        Assert.assertFalse(player.getHand().isHandEmpty());
    }

    @Test
    public void drawCardReturnsCorrectCardTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);
        GoFish.GoFishPlayer player = goFish.getHumanPlayer();

        PlayingCard expectedCard = goFish.getDeck().getAllCards().get(0);
        PlayingCard actualCard = player.drawCard();
        PlayingCard expectedHandCard = player.getHand().getAllCards().get(0);

        Assert.assertEquals(expectedCard, actualCard);
        Assert.assertEquals(expectedCard, expectedHandCard);
    }

    @Test
    public void hasFourOfKindTrueTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);

        for (int i = 0; i < 4; i++) {
            goFish.getCompPlayer().getHand().addCard(new PlayingCard(PlayingSuit.CLUB, PlayingValue.KING));
        }

        PlayingValue actual = goFish.getCompPlayer().fourOfKindValue();
        PlayingValue expected = PlayingValue.KING;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hasFourOfKindFalseTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);

        for (int i = 0; i < 3; i++) {
            goFish.getCompPlayer().getHand().addCard(new PlayingCard(PlayingSuit.CLUB, PlayingValue.KING));
        }

        PlayingValue actual = goFish.getCompPlayer().fourOfKindValue();
        PlayingValue expected = null;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void discardFourOfKindTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);
        GoFish.GoFishPlayer dealer = goFish.getCompPlayer();

        for (int i = 0; i < 4; i++) {
            dealer.getHand().addCard(new PlayingCard(PlayingSuit.CLUB, PlayingValue.KING));
        }
        for (int i = 0; i < 3; i++) {
            goFish.getCompPlayer().getHand().addCard(new PlayingCard(PlayingSuit.SPADE, PlayingValue.ACE));
        }

        Assert.assertEquals(4, (int)dealer.checkIfHandHasValue(PlayingValue.KING));
        Assert.assertEquals(3, (int)dealer.checkIfHandHasValue(PlayingValue.ACE));

        if(dealer.fourOfKindValue() != null){
            dealer.discardFourOfKind(dealer.fourOfKindValue());
        }

        Assert.assertEquals(0, (int)dealer.checkIfHandHasValue(PlayingValue.KING));
        Assert.assertEquals(3, (int)dealer.checkIfHandHasValue(PlayingValue.ACE));

    }

}
