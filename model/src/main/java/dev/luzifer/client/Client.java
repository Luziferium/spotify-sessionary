package dev.luzifer.client;

import dev.luzifer.user.User;

public class Client {
    
    public static User currentUser;
    
    public static void setCurrentUser(User user) {
        currentUser = user;
    }
    
    public static User getCurrentUser() {
        return currentUser;
    }
    
    private Client() {} // not sure if this class stays static
}
