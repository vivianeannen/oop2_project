package ch.fhnw.oop2.model;

import ch.fhnw.oop2.controller.BuildingsAppController;

/**
 * Created by Viviane on 06.12.2016.
 */
public class BuildingProxy extends BuildingPM{

    private BuildingPM currentBuilding;

    public void set(BuildingPM newBuildingPM){
        if(currentBuilding !=  null){
            cityProperty().unbindBidirectional(currentBuilding.cityProperty());
            rankProperty().unbindBidirectional(currentBuilding.rankProperty());


        }
        if(newBuildingPM != null){
            cityProperty().bindBidirectional(newBuildingPM.cityProperty());
            rankProperty().bindBidirectional(newBuildingPM.rankProperty());


        }
        currentBuilding = newBuildingPM;
    }


}
