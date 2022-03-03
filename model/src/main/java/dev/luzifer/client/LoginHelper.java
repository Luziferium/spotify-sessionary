package dev.luzifer.client;

import dev.luzifer.user.PersonalToken;
import dev.luzifer.user.User;

public class LoginHelper {
    
    public static boolean verifyLogin(PersonalToken personalToken) {
        
        // TODO
        Client.setCurrentUser(new User(personalToken));
        return true;
    }
    
    private LoginHelper() {}
    
}
