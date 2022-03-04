package dev.luzifer.ui.view;

import dev.luzifer.ui.viewmodel.LoginViewModel;
import dev.luzifer.ui.viewmodel.ViewModel;
import dev.luzifer.util.ImageHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;

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
    private Label informationLabel;
    
    @FXML
    private Button loginButton;
    
    public LoginView(ViewModel viewModel) {
        super(viewModel);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        LoginViewModel loginViewModel = (LoginViewModel) viewModel;
        loginViewModel.getIpProperty().bindBidirectional(serverField.textProperty());
        loginViewModel.getTokenProperty().bindBidirectional(tokenField.textProperty());
        loginViewModel.getLabelProperty().bindBidirectional(informationLabel.textProperty());
        
        ImageHelper.setFillImage(logoShape, "logo.png");
        ImageHelper.setBackgroundImage(pane, "background.png");
        ImageHelper.registerButtonImageChangeListener(loginButton);
    }
    
    @FXML
    void onButtonPress(ActionEvent event) {
        ((LoginViewModel) viewModel).tryLogin(); // kinda ugly
    }

}
