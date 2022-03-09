package dev.luzifer.ui;

import dev.luzifer.session.Session;

/**
 * Management class for {@link dev.luzifer.session.Session}
 */
public class SessionController {
    
    private final Session session;
    
    public SessionController() {
        this.session = new Session();
    }
    
}
