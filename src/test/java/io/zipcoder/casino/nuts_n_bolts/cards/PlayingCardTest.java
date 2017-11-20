package io.zipcoder.casino.nuts_n_bolts.cards;
import org.junit.Test;
package io.zipcoder.casino.casino;
import org.junit.Assert;

public class PlayingCardTest {

    @Test
    public void getSuitTest(){
        PlayingCard cardOne = new PlayingCard(PlayingSuit.CLUB, 4);
        Assert.assertEquals(4, cardOne.getSuit());
    }


    @Test
    public void getValueTest(){
        PlayingCard cardTwo = new PlayingCard(PlayingSuit.HEART,2);

        Assert.assertEquals(6, cardTwo.getValue());
    }


}
