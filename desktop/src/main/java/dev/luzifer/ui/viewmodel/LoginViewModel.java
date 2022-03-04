package dev.luzifer.ui.viewmodel;

import dev.luzifer.ui.util.PropertyNotNullChecker;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @see dev.luzifer.ui.view.View
 */
public class LoginViewModel implements ViewModel {

    private final StringProperty ipProperty = new SimpleStringProperty();
    private final StringProperty usernameProperty = new SimpleStringProperty();
    private final StringProperty labelProperty = new SimpleStringProperty();

    private final PropertyNotNullChecker propertyNotNullChecker = new PropertyNotNullChecker();

    private final Runnable callback;
    
    public LoginViewModel(Runnable callback) {

        this.callback = callback;

        propertyNotNullChecker.addProperties(ipProperty, usernameProperty);
    }

    public void tryConnect() {
        // TODO
        /*
        if true
            > callback
        else
            change label text
         */
        callback.run();
    }
    
    public ReadOnlyBooleanProperty allowedToSubmitProperty() {
        return propertyNotNullChecker.propertiesNotNullProperty();
    }

    public StringProperty getIpProperty() {
        return ipProperty;
    }
    
    public StringProperty getUsernameProperty() {
        return usernameProperty;
    }

    public StringProperty getLabelProperty() {
        return labelProperty;
    }

}
