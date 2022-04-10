package dev.luzifer.ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Sessionary extends Application {

    @Override
    public void start(Stage primaryStage) {

        ViewController viewController = new ViewController(primaryStage);
    }
}
