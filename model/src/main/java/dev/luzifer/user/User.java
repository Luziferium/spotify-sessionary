package dev.luzifer.user;

import java.sql.Timestamp;

public class User {
    
    private final String username;
    private final Timestamp loginStamp;
    
    User(String username) {
        this.username = username;
        this.loginStamp = new Timestamp(System.currentTimeMillis());
    }
    
    public String getUsername() {
        return username;
    }
    
    public Timestamp getLoginStamp() {
        return loginStamp;
    }
}
