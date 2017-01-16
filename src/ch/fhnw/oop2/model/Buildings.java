package ch.fhnw.oop2.model;

import ch.fhnw.oop2.controller.UndoRedoHandler;
import ch.fhnw.oop2.util.Utils;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;

/**
 * Created by norinasteiner on 17.12.16.
 */
public class Buildings {
	//TO automatically sort the buildings by height
	Callback<BuildingPM, Observable[]> cb = (BuildingPM building) -> new Observable[]{
			building.heightMProperty()
	};

	public ObservableList<BuildingPM> buildingsData = FXCollections.observableArrayList(cb);


    public Buildings(String list){
        try {
            buildingsData.setAll(Utils.readFromFile(list));
        } catch (Exception e) {
            Utils.printErrorMessage(e);
        }
    }

    public ObservableList<BuildingPM> getBuildingsData(){
        return buildingsData;
    }


    // new Buildings
    public void createnewBuilding() {
        buildingsData.addAll(new BuildingPM("","", "", "0.0", "", "", "", "","0.0","","0.0","","","0.0","0.0",
                UndoRedoHandler.getInstance().getPropertyChangeListenerForUndoSupport()));

    }

}
