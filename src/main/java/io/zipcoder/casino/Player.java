package io.zipcoder.casino;

public class Player {

    private Profile someProfile;

    public Player(Profile someProfile) {
        this.someProfile = someProfile;
    }

    public Player() {

    }

    public void setSomeProfile(Profile someProfile) {
        this.someProfile = someProfile;
    }

    // method mostly used for testing purposes
    public Profile getSomeProfile() {
        return someProfile;
    }
}
