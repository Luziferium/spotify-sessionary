package dev.luzifer.ui;

import dev.luzifer.ui.view.View;
import dev.luzifer.ui.viewmodel.ViewModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;

/**
 * Central point of contact for loading, connecting and opening {@link View} with its {@link ViewModel} - á la View-Controller.
 */
public class ViewController {

    private final Stage stage;

    public ViewController(Stage stage) {
        this.stage = stage;
    }
    
    /**
     * Closes the latest view
     *
     * @apiNote App will close if no other view is opened right after
     */
    public void closeLatestView(/* Might want to insert a callback with a View to open */) {
        stage.close();
    }
    
    /**
     * Opens the given {@link View} class to the end-user
     *
     * @param viewClass the class being opened
     * @param parameters possible parameters just like the {@link ViewModel}
     */
    public void showView(Class<? extends View> viewClass, Object... parameters) {
        loadAndShowView(viewClass, (Class<?> param) -> {
            
            try {
                return viewClass.getDeclaredConstructor(ViewModel.class).newInstance(parameters);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            throw new IllegalStateException("This shouldn't be!");
        }, viewClass.getSimpleName().substring(0, viewClass.getSimpleName().length() - 4));
    }
    
    /**
     * Here we overwrite the main {@link Stage} to the wished {@link View} and showing it to the end-user.
     */
    private <T> void loadAndShowView(Class<T> clazz, Callback<Class<?>, Object> controllerFactory, String title) {

        Parent root = loadView(clazz, controllerFactory);
        Scene scene = new Scene(root);

        stage.getIcons().addAll(new Image("logo.png"));
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.show();
    }
    
    /**
     * Here we are loading the wished {@link View} out of their corresponding FXML-file
     */
    private <T> Parent loadView(Class<T> clazz, Callback<Class<?>, Object> controllerFactory) {

        FXMLLoader fxmlLoader = new FXMLLoader();

        URL fxmlLocation = clazz.getResource(clazz.getSimpleName() + ".fxml");

        fxmlLoader.setLocation(fxmlLocation);
        fxmlLoader.setControllerFactory(controllerFactory);

        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            throw new IllegalStateException(MessageFormat.format("FXML could not get loaded for class: {0}", clazz), e);
        }
    }

}
