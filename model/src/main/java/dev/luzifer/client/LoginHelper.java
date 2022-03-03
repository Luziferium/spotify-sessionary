package dev.luzifer.client;

import dev.luzifer.user.PersonalToken;

public class LoginHelper {
    
    /**
     * Tries to verify the {@link PersonalToken} and therewith login the user.
     *
     * @return whether the token could be verified or not
     */
    public static boolean verifyLogin(PersonalToken personalToken) {
        /*
        Client.setCurrentUser(new User(personalToken));
        return true;
         */
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    /**
     * Connects the Client to the given IP if possible.
     *
     * At this point the Client will be set.
     */
    public static void connect(String ip) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    private LoginHelper() {}
    
}
