package dev.luzifer.user;

import java.sql.Timestamp;

public class User {
    
    private final String username;
    private final Timestamp loginStamp;
    
    public User(String username) {
        this.username = username;
        this.loginStamp = new Timestamp(System.currentTimeMillis());
    }
}
