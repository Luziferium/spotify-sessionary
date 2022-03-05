package dev.luzifer.ui.view;

import dev.luzifer.ui.util.ImageHelper;
import dev.luzifer.ui.viewmodel.ViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Separator;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class SessionaryView extends View {
    
    @FXML
    private Pane pane;
    
    @FXML
    private ProgressBar songProgress;
    
    @FXML
    private Button playPauseButton;
    
    @FXML
    private Circle logoShape;
    
    @FXML
    private Label nameLabel;
    
    @FXML
    private ListView<?> playlistList;
    
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
        ImageHelper.setBackgroundImage(pane, "background.png");
    }
    
    @FXML
    void onButtonPress(ActionEvent event) {
    
    }
}
