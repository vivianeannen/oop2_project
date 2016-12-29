package ch.fhnw.oop2.controller;

import ch.fhnw.oop2.controller.Command;
import ch.fhnw.oop2.model.BuildingPM;
import javafx.beans.property.Property;

/**
 * Created by norinasteiner on 29.12.16.
 */
public class ValueChangeCommand<T> implements Command {
    private final BuildingsAppController building;
    private final Property<T> property;
    private final T           oldValue;
    private final T           newValue;

    public ValueChangeCommand(BuildingsAppController building, Property<T> property, T oldValue, T newValue) {
        this.building = building;
        this.property = property;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public void undo() {
        building.setPropertyValueWithoutUndoSupport(property, oldValue);
    }

    public void redo() {
        building.setPropertyValueWithoutUndoSupport(property, newValue);
    }
}







