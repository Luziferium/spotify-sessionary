package dev.luzifer.ui.view;

import dev.luzifer.ui.viewmodel.ViewModel;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class View implements Initializable {
    
    protected final ViewModel viewModel;
    
    protected View(ViewModel viewModel) {
        this.viewModel = viewModel;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    
    }
}
