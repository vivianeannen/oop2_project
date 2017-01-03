package ch.fhnw.oop2.controller;

import javafx.beans.property.Property;

/**
 * Created by norinasteiner on 29.12.16.
 */

public class ValueChangeCommand<T> implements Command {
    private final Property<T> property;
    private final T oldValue;
    private final T newValue;

    public ValueChangeCommand(Property<T> property, T oldValue, T newValue) {
        this.property = property;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public void undo() {
        UndoRedoHandler.getInstance().setPropertyValueWithoutUndoSupport(property, oldValue);
    }

    public void redo() {
        UndoRedoHandler.getInstance().setPropertyValueWithoutUndoSupport(property, newValue);
    }
}







