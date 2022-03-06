package dev.luzifer.ui.view;

import dev.luzifer.ui.util.ImageHelper;
import dev.luzifer.ui.viewmodel.SessionaryViewModel;
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
    private VBox playlistVBox;
    
    @FXML
    private VBox userVBox;
    
    @FXML
    private Separator verticalSeparator;
    
    @FXML
    private Separator horizontalSeparator;
    
    public SessionaryView(ViewModel viewModel) {
        super(viewModel);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    
        ImageHelper.setFillImage(logoShape, "images/logo.png");
        ImageHelper.setFillImage(playPauseButtonShape, "images/playLogo.png");
        ImageHelper.setBackgroundImage(pane, "images/sessionary_background.png");
        ImageHelper.setBackgroundImage(playlistVBox, "images/sessionary_list_background.png");
        
        Label label = new Label("User", new ImageView("images/user_icon.png"));
        label.setTextFill(Color.WHEAT);
        label.setFont(new Font("Arial", 16));
        
        userVBox.getChildren().add(label);
        addContextMenu();
    }
    
    private void addContextMenu() {
        
        ContextMenu contextMenu = new ContextMenu();
        MenuItem menuItem = new MenuItem("Add Song");
        MenuItem menuItem2 = new MenuItem("your nomn (close)");
        MenuItem menuItem3 = new MenuItem("Fuck Yourself (close and fuck yourself)");
        contextMenu.getItems().addAll(menuItem, menuItem2, menuItem3);
    
        menuItem.setOnAction(actionEvent -> showSongLinkInputDialog());
    
        playlistVBox.setOnContextMenuRequested(contextMenuEvent -> contextMenu.show(pane, contextMenuEvent.getScreenX(), contextMenuEvent.getScreenY()));
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
        
            if(playlistVBox.getChildren().size() >= 12) {
            
                showMaxSongsReachedAlert();
                return;
            }
        
            Label label = new Label(textInputDialog.getResult(), new ImageView("images/song_icon.png"));
            label.setTextFill(Color.WHEAT);
            label.setFont(new Font("Arial", 18));
    
            playlistVBox.getChildren().add(label);
        });
        textInputDialog.show();
    }
    
}
