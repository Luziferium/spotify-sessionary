package dev.luzifer.ui.view;

import dev.luzifer.ui.util.ImageHelper;
import dev.luzifer.ui.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Separator;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class SessionaryView extends View {
    
    @FXML
    private Pane pane;
    
    @FXML
    private ProgressBar songProgress;
    
    @FXML
    private Circle playPauseButtonShape;
    
    @FXML
    private Circle logoShape;
    
    @FXML
    private Label nameLabel;
    
    @FXML
    private VBox vBox;
    
    @FXML
    private Separator verticalSeparator;
    
    @FXML
    private Separator horizontalSeparator;
    
    public SessionaryView(ViewModel viewModel) {
        super(viewModel);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    
        ImageHelper.setFillImage(logoShape, "logo.png");
        ImageHelper.setFillImage(playPauseButtonShape, "playLogo.png"); // TODO: pressedPropertyListener
        ImageHelper.setBackgroundImage(pane, "sessionary_background.png");
        ImageHelper.setBackgroundImage(vBox, "sessionary_list_background.png");
    }
}
