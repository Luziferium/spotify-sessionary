package dev.luzifer.util;

import javafx.geometry.Side;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Region;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Shape;

import java.net.URL;
import java.text.MessageFormat;

public class ImageHelper {
    
    public static void setFillImage(Shape shape, String imageName) {
        
        URL url = ImageHelper.class.getClassLoader().getResource("logo.png");
        if(url == null)
            throw new IllegalStateException(MessageFormat.format("A resource with this name could not be found: {0}", imageName));
    
        shape.setFill(new ImagePattern(new Image(url.toExternalForm())));
    }
    
    public static void setBackgroundImage(Region region, String imageName) {
        region.setBackground(new Background(convertPNGToBackgroundImage(imageName)));
    }
    
    private static BackgroundImage convertPNGToBackgroundImage(String name) {
        
        URL url = ImageHelper.class.getClassLoader().getResource(name);
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
