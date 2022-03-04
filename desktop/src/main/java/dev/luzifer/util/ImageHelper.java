package dev.luzifer.util;

import javafx.geometry.Side;
import javafx.scene.control.Button;
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
    
    /**
     * This method applies a listener to the button whose check if the button has been pressed or released.
     * If the listener is being fired the button will hold a new {@link BackgroundImage} corresponding to the made action.
     *
     * @param button the button the listener is applied on
     */
    public static void registerButtonImageChangeListener(Button button) {
        
        setBackgroundImage(button, "button_normal.png");
        
        button.pressedProperty().addListener(((observableValue, wasPressed, pressed) -> {
            
            if(pressed)
                setBackgroundImage(button, "button_pressed.png");
            else
                setBackgroundImage(button, "button_normal.png");
        }));
    }
    
    /**
     * This method does set an {@link ImagePattern} as fill of a {@link Shape}.
     * Means the background is being set.
     */
    public static void setFillImage(Shape shape, String imageName) {
        
        URL url = ImageHelper.class.getClassLoader().getResource("logo.png");
        if(url == null)
            throw new IllegalStateException(MessageFormat.format("A resource with this name could not be found: {0}", imageName));
    
        Image image = getImageByURL(fetchResourceAsURL(imageName));
        shape.setFill(new ImagePattern(image));
    }
    
    /**
     * This method sets the {@link BackgroundImage} of a {@link Region}, means Buttons, Panes, Fields etc.
     */
    public static void setBackgroundImage(Region region, String imageName) {
        region.setBackground(new Background(convertPNGToBackgroundImage(imageName)));
    }
    
    private static BackgroundImage convertPNGToBackgroundImage(String name) {
        
        Image image = getImageByURL(fetchResourceAsURL(name));
        
        return new BackgroundImage(
                image,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
        );
    }
    
    private static Image getImageByURL(URL url) {
        return new Image(url.toExternalForm());
    }
    
    private static URL fetchResourceAsURL(String name) {
    
        URL url = ImageHelper.class.getClassLoader().getResource(name);
        if(url == null)
            throw new IllegalStateException(MessageFormat.format("A resource with this name could not be found: {0}", name));
        
        return url;
    }
    
    private ImageHelper() {}
    
}
