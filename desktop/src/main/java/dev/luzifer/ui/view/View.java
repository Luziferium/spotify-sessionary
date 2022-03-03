package dev.luzifer.ui.view;

import dev.luzifer.ui.viewmodel.ViewModel;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public abstract class View implements Initializable {
    
    protected final ViewModel viewModel;
    
    protected View(ViewModel viewModel) {
        this.viewModel = viewModel;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    
    }
    
    protected BackgroundImage convertPNGToBackgroundImage(String name) {
        
        URL url = getClass().getClassLoader().getResource(name);
        if(url == null)
            throw new IllegalStateException(MessageFormat.format("A resource with this name could not be found: {0}", name));
        
        Image image = new Image(url.toExternalForm());
        
        return new BackgroundImage(
                image,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
        );
    }
}
