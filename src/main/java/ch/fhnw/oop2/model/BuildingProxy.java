package ch.fhnw.oop2.model;

/**
 * Created by Viviane on 06.12.2016.
 */
public class BuildingProxy {

    private BuildingPM currentBuilding;



    public void set(BuildingPM newBuilding){
        if(currentBuilding != null){
            currentBuilding.cityProperty().unbindBidirectional(currentBuilding.cityProperty());
        }

        if(newBuilding != null){
            newBuilding.cityProperty().bindBidirectional(currentBuilding.cityProperty());
        }

        currentBuilding = newBuilding;

    }



}
