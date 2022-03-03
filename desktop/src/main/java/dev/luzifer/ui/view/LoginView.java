package dev.luzifer.ui.view;

import dev.luzifer.ui.viewmodel.LoginViewModel;
import dev.luzifer.ui.viewmodel.ViewModel;
import dev.luzifer.user.PersonalToken;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginView extends View {
    
    @FXML
    private Pane pane;
    
    @FXML
    private Rectangle logoShape;
    
    @FXML
    private TextField serverField;
    
    @FXML
    private PasswordField tokenField;
    
    @FXML
    private Button loginButton;
    
    public LoginView(ViewModel viewModel) {
        super(viewModel);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logoShape.setFill(new ImagePattern(new Image(getClass().getClassLoader().getResource("logo.png").toExternalForm())));
    }
    
    @FXML
    void onButtonPress(ActionEvent event) {
        ((LoginViewModel) viewModel).tryLogin(PersonalToken.of(tokenField.getText()));
    }
}
