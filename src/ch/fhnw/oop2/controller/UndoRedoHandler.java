package ch.fhnw.oop2.controller;

import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Viviane on 03.01.2017.
 */
public class UndoRedoHandler {
    private static UndoRedoHandler singleton;

    public static UndoRedoHandler getInstance() {
        if (singleton == null) {
            singleton = new UndoRedoHandler();
        }
        return singleton;
    }

    private UndoRedoHandler() {
        //private for singleton
    }

    //UNDO REDO
    private final ObservableList<Command> undoStack = FXCollections.observableArrayList();
    private final ObservableList<Command> redoStack = FXCollections.observableArrayList();
    private final ChangeListener propertyChangeListenerForUndoSupport = (observable, oldValue, newValue) -> {
        redoStack.clear();
        undoStack
                .add(0, new ValueChangeCommand((Property) observable, oldValue, newValue));
    };

    public ChangeListener getPropertyChangeListenerForUndoSupport() {
        return propertyChangeListenerForUndoSupport;
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            return;
        }
        Command cmd = undoStack.get(0);
        undoStack.remove(0);
        redoStack.add(0, cmd);

        cmd.undo();
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            return;
        }
        Command cmd = redoStack.get(0);
        redoStack.remove(0);
        undoStack.add(0, cmd);

        cmd.redo();
    }

    public <T> void setPropertyValueWithoutUndoSupport(Property<T> property, T newValue) {
        property.removeListener(propertyChangeListenerForUndoSupport);
        property.setValue(newValue);
        property.addListener(propertyChangeListenerForUndoSupport);
    }
}
