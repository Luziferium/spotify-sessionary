package dev.luzifer.ui.viewmodel;

import dev.luzifer.client.LoginHelper;
import dev.luzifer.user.PersonalToken;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;

/**
 * @see dev.luzifer.ui.view.View
 */
public class LoginViewModel implements ViewModel {
    
    private final StringProperty ipProperty = new SimpleStringProperty();
    private final StringProperty tokenProperty = new SimpleStringProperty();
    private final StringProperty labelProperty = new SimpleStringProperty();
    
    private final Runnable callback;
    
    public LoginViewModel(Runnable callback) {
        this.callback = callback;
    }
    
    /**
     * Tries to verify the given {@link PersonalToken} and, if successful, to connect to the server with the given IP.
     *
     * Shows an error-dialog if the login could not be verified.
     */
    public void tryLogin() {

        if(LoginHelper.verifyLogin(PersonalToken.of(getTokenProperty().get()))) {
            LoginHelper.connect(getIpProperty().get());
            callback.run();
        } else {
            labelProperty.setValue("Token is invalid!");
        }
    }
    
    public StringProperty getIpProperty() {
        return ipProperty;
    }
    
    public StringProperty getTokenProperty() {
        return tokenProperty;
    }

    public StringProperty getLabelProperty() {
        return labelProperty;
    }

}
