package ch.fhnw.oop2.model;

import ch.fhnw.oop2.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by norinasteiner on 17.12.16.
 */
public class Buildings {

    public ObservableList<BuildingPM> buildingsData = FXCollections.observableArrayList();


    public Buildings(String list){
        buildingsData.setAll(Utils.readFromFile(list));
    }



    public ObservableList<BuildingPM> getBuildingsData(){
        return buildingsData;
    }


    // new Buildings
    public void createnewBuilding() {
        buildingsData.addAll(new BuildingPM("","", "", "", "", "", "", "","","","","","","",""));

    }

}
