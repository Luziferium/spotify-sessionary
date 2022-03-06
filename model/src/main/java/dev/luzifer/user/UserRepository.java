package dev.luzifer.user;

import dev.luzifer.response.Response;

import java.util.HashSet;
import java.util.Set;

public class UserRepository {
    
    private final Set<User> users = new HashSet<>();
    
    public void removeUser(User user) {
        users.remove(user);
    }
    
    public Response<User> createUser(String username) {
        
        User user = findUser(username).getValue();
        if(user != null)
            return new Response<>(user, "User does already exist");
            
        user = new User(username);
        users.add(user);
        
        return new Response<>(user);
    }
    
    public Response<User> findUser(String username) {
        
        for(User user : users)
            if(user.getUsername().equalsIgnoreCase(username))
                return new Response<>(user);
        
        return new Response<>(null, "User not found");
    }
    
    public Set<User> getUsers() {
        return users;
    }
}
