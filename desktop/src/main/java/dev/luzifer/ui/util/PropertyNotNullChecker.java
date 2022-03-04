package dev.luzifer.ui.util;

import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableObjectValue;
import javafx.beans.value.ObservableValue;

import java.util.ArrayList;
import java.util.List;

public class PropertyNotNullChecker {

    private final List<Property<?>> properties = new ArrayList<>();

    private final ReadOnlyBooleanWrapper propertiesNotNull = new ReadOnlyBooleanWrapper();
    private final ChangeListener<Object> propertyChangeListener = new PropertyChangeListener();

    /**
     * Adds a {@link Property} to the checker to check if its null or, in case of a String, empty
     */
    public void addProperty(Property<?> property) {

        properties.add(property);
        property.addListener(propertyChangeListener);

        propertiesNotNull.setValue(!isAnyPropertyNull());
    }

    /**
     * Adds every passed {@link Property} by calling {@link #addProperty(Property)} on it
     */
    public void addProperties(Property<?>... properties) {

        for (Property<?> property : properties)
            addProperty(property);
    }

    /**
     * The value which is based on if any of the given properties is null or empty.
     *
     *  @return true if all properties are whether null nor empty
     */
    public ReadOnlyBooleanProperty propertiesNotNullProperty() {
        return propertiesNotNull.getReadOnlyProperty();
    }

    /*
     * Iterating through the given properties to check for null or, in case of a String, empty
     */
    private boolean isAnyPropertyNull() {

        for (Property<?> property : properties)
            if (property.getValue() == null || property instanceof StringProperty && ((ObservableObjectValue<String>) property).get().isEmpty())
                return true;

        return false;
    }

    /*
     * An inner class which acts as a {@link ChangeListener} with the order to check the given properties for null or, in case of a String, empty
     */
    private class PropertyChangeListener implements ChangeListener<Object> {

        @Override
        public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
            propertiesNotNull.setValue(!isAnyPropertyNull());
        }
    }

}
