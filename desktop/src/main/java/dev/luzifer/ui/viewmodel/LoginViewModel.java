package dev.luzifer.ui.viewmodel;

import dev.luzifer.client.LoginHelper;
import dev.luzifer.ui.ViewController;
import dev.luzifer.user.PersonalToken;
import javafx.scene.control.Alert;

/**
 * @see dev.luzifer.ui.view.View
 */
public class LoginViewModel implements ViewModel {
    
    // Does this belong here?
    // Maybe redirect a callback?
    private final ViewController viewController;
    
    public LoginViewModel(ViewController viewController) {
        this.viewController = viewController;
    }
    
    public void tryLogin(PersonalToken personalToken) {
        
        if(!LoginHelper.verifyLogin(personalToken))
            error("Not able to login");
        else
            viewController.closeLatestView();// open next view
    }
    
    private void error(String msg) {
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("AN ERROR OCCURRED");
        alert.setContentText(msg);
        alert.showAndWait();
    }
    
}
