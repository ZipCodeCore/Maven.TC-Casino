package io.zipcoder.casino.nuts_n_bolts;

public class UserTest {
}


/*
*
    @Test
    public void getNameTest() {
        //: Given
        Player testPlayer = new Player("Gabriela");
        String expected = "Gabriela";

        //: When
        String actual = testPlayer.getName();

        //: Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMoneyTest(){
        Player testPlayer = new Player("Claude");
        Double expected = 500d;

        Double actual = testPlayer.getMoney();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScoreTest(){
        Player testPlayer = new Player("Zan");
        Integer expected = Integer.valueOf(0);

        Integer actual = testPlayer.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandTest(){
        Player testPlayer = new Player ("Aaron");
        testPlayer.addToHand(new Card(Suit.HEARTS, 8));
        testPlayer.addToHand(new Card(Suit.HEARTS, 7));
        int expected = 2;

        int actual = testPlayer.getHand().size();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void addCardTest(){
        Player testPlayer = new Player ("Pavel");
        Card card = new Card(Suit.CLUBS, 3);
        testPlayer.addToHand(card);
        Card expected = card;

        Card actual = testPlayer.getHand().get(0);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void hasMoneyToMakeBetTest() {
        Player testPlayer = new Player("Leon");
        boolean expected = true;

        boolean actual = testPlayer.hasMoneyToMakeBet(Double.valueOf(100));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void makeBetTest() {
        Player testPlayer = new Player("Tim");
        Double expected = Double.valueOf(400);

        testPlayer.makeBet(Double.valueOf(100));
        Double actual = testPlayer.getMoney();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isAceInHandTest() {
        Player testPlayer = new Player("Tim");
        Card ace = new Card(Suit.HEARTS, 1);
        Card nine = new Card(Suit.CLUBS, 9);
        testPlayer.addToHand(ace);
        testPlayer.addToHand(nine);
        boolean expected = true;

        boolean actual = testPlayer.isAceInHand();

    }

    @Test
    public void calculateScoreTest() {
        Player testPlayer = new Player("Tim");
        Card ace = new Card(Suit.HEARTS, 1);
        Card nine = new Card(Suit.CLUBS, 9);
        testPlayer.addToHand(ace);
        testPlayer.addToHand(nine);
        int expected = 20;

        int actual = testPlayer.calculateScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculateScoreTest2() {
        Player testPlayer = new Player("Tim");
        Card ace = new Card(Suit.HEARTS, 1);
        Card ace2 = new Card(Suit.CLUBS, 1);
        testPlayer.addToHand(ace);
        testPlayer.addToHand(ace2);
        int expected = 12;

        int actual = testPlayer.calculateScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void receiveWinningsTest() {
        Player testPlayer = new Player("Tim");
        Double expected = Double.valueOf(600);

        testPlayer.receiveWinnings(Double.valueOf(100));
        Double actual = testPlayer.getMoney();

        Assert.assertEquals(expected, actual);
    }

* */