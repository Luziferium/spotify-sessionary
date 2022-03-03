package dev.luzifer.client;

import dev.luzifer.user.PersonalToken;
import dev.luzifer.user.User;

public class LoginHelper {
    
    /**
     * Tries to verify the {@link PersonalToken} and therewith login the user.
     *
     * @return whether the token could be verified or not
     */
    public static boolean verifyLogin(PersonalToken personalToken) {
        
        // TODO
        Client.setCurrentUser(new User(personalToken));
        return true;
    }
    
    private LoginHelper() {}
    
}
