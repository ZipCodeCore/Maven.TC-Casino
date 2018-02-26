package io.zipcoder.casino;

public class Player {

    private Profile playerProfile;

    public Player(Profile someProfile) {
        this.playerProfile = someProfile;
    }

    public Player() {

    }

    public void setProfile(Profile someProfile) {
        this.playerProfile = someProfile;
    }

    // method mostly used for testing purposes
    public Profile getProfile() {
        return playerProfile;
    }
}
