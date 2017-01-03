package ch.fhnw.oop2.model;

/**
 * Created by Viviane on 06.12.2016.
 */
public class BuildingProxy extends BuildingPM {

    private BuildingPM currentBuilding;

    public void set(BuildingPM newBuildingPM) {
        if (currentBuilding != null) {
            cityProperty().unbindBidirectional(currentBuilding.cityProperty());
            rankProperty().unbindBidirectional(currentBuilding.rankProperty());
            nameProperty().unbindBidirectional(currentBuilding.nameProperty());
            heightFTProperty().unbindBidirectional(currentBuilding.heightFTProperty());
            heightMProperty().unbindBidirectional(currentBuilding.heightMProperty());
            costProperty().unbindBidirectional(currentBuilding.costProperty());
            architectProperty().unbindBidirectional(currentBuilding.architectProperty());
            floorsProperty().unbindBidirectional(currentBuilding.floorsProperty());
            architectualStyleProperty().unbindBidirectional(currentBuilding.architectualStyleProperty());
            longitudeProperty().unbindBidirectional(currentBuilding.longitudeProperty());
            latitudeProperty().unbindBidirectional(currentBuilding.latitudeProperty());
            countryProperty().unbindBidirectional(currentBuilding.countryProperty());
            buildProperty().unbindBidirectional(currentBuilding.buildProperty());
            materialProperty().unbindBidirectional(currentBuilding.materialProperty());

        }
        if (newBuildingPM != null) {
            cityProperty().bindBidirectional(newBuildingPM.cityProperty());
            rankProperty().bindBidirectional(newBuildingPM.rankProperty());
            nameProperty().bindBidirectional(newBuildingPM.nameProperty());
            heightFTProperty().bindBidirectional(newBuildingPM.heightFTProperty());
            heightMProperty().bindBidirectional(newBuildingPM.heightMProperty());
            costProperty().bindBidirectional(newBuildingPM.costProperty());
            architectProperty().bindBidirectional(newBuildingPM.architectProperty());
            floorsProperty().bindBidirectional(newBuildingPM.floorsProperty());
            architectualStyleProperty().bindBidirectional(newBuildingPM.architectualStyleProperty());
            longitudeProperty().bindBidirectional(newBuildingPM.longitudeProperty());
            latitudeProperty().bindBidirectional(newBuildingPM.latitudeProperty());
            countryProperty().bindBidirectional(newBuildingPM.countryProperty());
            buildProperty().bindBidirectional(newBuildingPM.buildProperty());
            materialProperty().bindBidirectional(newBuildingPM.materialProperty());

        }
        currentBuilding = newBuildingPM;
    }

}
