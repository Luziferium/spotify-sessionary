package dev.luzifer.ui.view.views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginView implements Initializable {

    @FXML
    private Label backgroundLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backgroundLabel.setBackground(new Background(backgroundImage()));
    }

    private BackgroundImage backgroundImage() {

        Image image = new Image(getClass().getClassLoader().getResource("logo.png").toExternalForm());

        return new BackgroundImage(
                image,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
        );
    }
}
