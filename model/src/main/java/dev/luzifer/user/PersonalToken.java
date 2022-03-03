package dev.luzifer.user;

import java.nio.charset.StandardCharsets;

public class PersonalToken {
    
    public static PersonalToken of(String token) {
        return new PersonalToken(token);
    }
    
    private final byte[] token;
    
    private PersonalToken(String token) {
        this.token = token.getBytes(StandardCharsets.UTF_8);
    }
    
    public byte[] getToken() {
        return token;
    }
}
