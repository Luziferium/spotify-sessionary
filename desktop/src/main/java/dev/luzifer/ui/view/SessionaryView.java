package dev.luzifer.ui.view;

import dev.luzifer.ui.util.ImageHelper;
import dev.luzifer.ui.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class SessionaryView extends View {
    
    @FXML
    private Pane pane;
    
    @FXML
    private Separator seperator1;
    
    @FXML
    private Separator seperator2;
    
    @FXML
    private AnchorPane anchorPane1;
    
    @FXML
    private AnchorPane anchorPane2;
    
    @FXML
    private AnchorPane anchorPane3;
    
    public SessionaryView(ViewModel viewModel) {
        super(viewModel);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageHelper.setBackgroundImage(pane, "background.png");
    }
}
