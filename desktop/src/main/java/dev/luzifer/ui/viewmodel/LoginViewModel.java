package dev.luzifer.ui.viewmodel;

import dev.luzifer.client.LoginHelper;
import dev.luzifer.ui.ViewController;
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
    
    // Does this belong here?
    // Maybe redirect a callback?
    private final ViewController viewController;
    
    public LoginViewModel(ViewController viewController) {
        this.viewController = viewController;
    }
    
    public void tryLogin() {
    
        if(LoginHelper.verifyLogin(PersonalToken.of(getTokenProperty().get()))) {
    
            LoginHelper.connect(getIpProperty().get());
            viewController.closeLatestView();
            // TODO: open next view
        } else {
            error("Not able to login");
        }
    }
    
    public StringProperty getIpProperty() {
        return ipProperty;
    }
    
    public StringProperty getTokenProperty() {
        return tokenProperty;
    }
    
    private void error(String msg) {
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("AN ERROR OCCURRED");
        alert.setContentText(msg);
        alert.showAndWait();
    }
    
}
