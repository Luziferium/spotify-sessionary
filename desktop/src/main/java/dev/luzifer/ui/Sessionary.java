package dev.luzifer.ui;

import dev.luzifer.ui.view.LoginView;
import dev.luzifer.ui.viewmodel.LoginViewModel;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Our application representation
 */
public class Sessionary extends Application {

    @Override
    public void start(Stage primaryStage) {

        ViewController viewController = new ViewController(primaryStage);
        viewController.showView(LoginView.class, new LoginViewModel(viewController));
    }
}
