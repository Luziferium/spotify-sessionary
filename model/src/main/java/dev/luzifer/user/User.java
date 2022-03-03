package dev.luzifer.user;

import java.sql.Timestamp;

public class User {
    
    private final PersonalToken token;
    private final Timestamp loginStamp;
    
    public User(PersonalToken token) {
        this.token = token;
        this.loginStamp = new Timestamp(System.currentTimeMillis());
    }
}
