package dev.luzifer.ui.viewmodel;

import dev.luzifer.client.LoginHelper;
import dev.luzifer.ui.util.PropertyNotNullChecker;
import dev.luzifer.user.PersonalToken;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @see dev.luzifer.ui.view.View
 */
public class LoginViewModel implements ViewModel {

    private final StringProperty ipProperty = new SimpleStringProperty();
    private final StringProperty tokenProperty = new SimpleStringProperty();
    private final StringProperty labelProperty = new SimpleStringProperty();

    private final PropertyNotNullChecker propertyNotNullChecker = new PropertyNotNullChecker();

    private final Runnable callback;
    
    public LoginViewModel(Runnable callback) {

        this.callback = callback;

        propertyNotNullChecker.addProperties(ipProperty, tokenProperty);
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

    public ReadOnlyBooleanProperty getSubmitProperty() {
        return propertyNotNullChecker.propertiesNotNullProperty();
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
