package com.belatrix.easyroom.entities;

/**
 * Created by pcarrillo on 07/08/2015.
 */
public class Booking {

    private User user;
    private String title;

    public Booking( User user, String title) {
        this.user = user;
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
