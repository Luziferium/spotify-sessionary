package dev.luzifer.ui.view;

import dev.luzifer.ui.util.ImageHelper;
import dev.luzifer.ui.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Separator;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

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
        
        addContextMenu();
    }
    
    private void addContextMenu() {
        
        ContextMenu contextMenu = new ContextMenu();
        MenuItem menuItem = new MenuItem("Add Song");
        MenuItem menuItem2 = new MenuItem("your nomn (close)");
        MenuItem menuItem3 = new MenuItem("Fuck Yourself (close and fuck yourself)");
        contextMenu.getItems().addAll(menuItem, menuItem2, menuItem3);
    
        menuItem.setOnAction(actionEvent -> showSongLinkInputDialog());
    
        vBox.setOnContextMenuRequested(contextMenuEvent -> contextMenu.show(pane, contextMenuEvent.getScreenX(), contextMenuEvent.getScreenY()));
    }
    
    private void showMaxSongsReachedAlert() {
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Maximus prime songs reached! :(");
        alert.setHeaderText("");
        alert.setTitle("haha no");
        alert.show();
    }
    
    private void showSongLinkInputDialog() {
        
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setContentText("Input song link from Spotify:");
        textInputDialog.setTitle("haha yes");
        textInputDialog.setHeaderText("");
        textInputDialog.setGraphic(null);
        textInputDialog.setOnCloseRequest(dialogEvent -> {
        
            if(vBox.getChildren().size() >= 12) {
            
                showMaxSongsReachedAlert();
                return;
            }
        
            Label label = new Label(textInputDialog.getResult(), new ImageView("songicon.png"));
            label.setTextFill(Color.WHEAT);
            label.setFont(new Font("Arial", 18));
        
            vBox.getChildren().add(label);
        });
        textInputDialog.show();
    }
    
}
