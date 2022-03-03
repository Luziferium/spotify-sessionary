package dev.luzifer.user;

public class PersonalToken {
    
    public static PersonalToken of(String token) {
        return new PersonalToken(token);
    }
    
    private final String token;
    
    private PersonalToken(String token) {
        this.token = token;
    }
    
    public String getToken() {
        return token;
    }
}
