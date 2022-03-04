package dev.luzifer.ui;

import dev.luzifer.ui.view.LoginView;
import dev.luzifer.ui.view.SessionaryView;
import dev.luzifer.ui.viewmodel.LoginViewModel;
import dev.luzifer.ui.viewmodel.SessionaryViewModel;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Our application representation
 */
public class Sessionary extends Application {

    @Override
    public void start(Stage primaryStage) {

        ViewController viewController = new ViewController(primaryStage);
        viewController.showView(LoginView.class, new LoginViewModel(() -> {
            
            viewController.closeLatestView();
            viewController.showView(SessionaryView.class, new SessionaryViewModel());
        }));
    }
}
