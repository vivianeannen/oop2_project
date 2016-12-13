package ch.fhnw.oop2.controller;

import ch.fhnw.oop2.BuildingsApp;
import ch.fhnw.oop2.model.BuildingPM;
import ch.fhnw.oop2.model.BuildingProxy;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import javafx.event.ActionEvent;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by norinasteiner on 01.12.16.
 */
public class BuildingsAppController implements Initializable {

    //***attributes***

    public BuildingsApp main;
    private ResourceBundle bundle;
    private BuildingPM buildingPM;
    private BuildingProxy buildingProxy = new BuildingProxy();



    //@FXML

    @FXML
    public TableView<BuildingPM> tvBuildings;

    @FXML
    public TableColumn<BuildingPM, String> tcName;
    @FXML
    public TableColumn<BuildingPM, String> tcCity;
    @FXML
    public TableColumn<BuildingPM, String> tcRank;
    @FXML
    public Label lName;
    @FXML
    public TextField lCity;
    @FXML
    public Label lHeightm;
    @FXML
    public Label lFloors;
    @FXML
    public Label lArchitect;
    @FXML
    public Label lCost;
    @FXML
    public Label lLongitude;
    @FXML
    public Label lCountry;
    @FXML
    public Label lHeightft;
    @FXML
    public Label lBuild;
    @FXML
    public Label lArchitectual;
    @FXML
    public Label lMaterial;
    @FXML
    public Label lLatitude;
    @FXML
    public Label lRank;
    @FXML
    public Label laName;
    @FXML
    public Label laCity;
    @FXML
    public Label laHeightm;


    //***initialize***

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        tcCity.setCellValueFactory(cellData -> cellData.getValue().cityProperty());

        tcRank.setCellValueFactory(cellData -> cellData.getValue().rankProperty());

        // Clear buildings details.
        showBuildingDetails(null);
        // Listen for selection changes and show the builduings details when changed.
        tvBuildings.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showBuildingDetails(newValue));


    }

    //***methods***
    private void showBuildingDetails(BuildingPM building) {
        if (building != null) {
            buildingProxy.set(building);
        } else {
            // Building is null, remove all the text.

            lName.setText("");
            lCity.setText("");
            lHeightm.setText("");
            lFloors.setText("");
            lArchitect.setText("");
            lCost.setText("");
            lLongitude.setText("");
            lCountry.setText("");
            lHeightft.setText("");
            lBuild.setText("");
            lArchitectual.setText("");
            lMaterial.setText("");
            lLatitude.setText("");
            lRank.setText("");
            laHeightm.setText("");
            laName.setText("");
            laCity.setText("");
        }


    }


    public void setMain(BuildingsApp main) {
        this.main = main;



        buildingProxy.cityProperty().bindBidirectional(lCity.textProperty());
        buildingProxy.nameProperty().bindBidirectional(lName.textProperty());
        buildingProxy.nameProperty().bindBidirectional(laName.textProperty());
        buildingProxy.buildProperty().bindBidirectional(lBuild.textProperty());
        buildingProxy.cityProperty().bindBidirectional(laCity.textProperty());
        buildingProxy.latitudeProperty().bindBidirectional(lLatitude.textProperty());
        buildingProxy.longitudeProperty().bindBidirectional(lLongitude.textProperty());
        buildingProxy.heightFTProperty().bindBidirectional(lHeightft.textProperty());
        buildingProxy.heightMProperty().bindBidirectional(lHeightm.textProperty());
        buildingProxy.heightMProperty().bindBidirectional(laHeightm.textProperty());
        buildingProxy.countryProperty().bindBidirectional(lCountry.textProperty());
        buildingProxy.materlialProperty().bindBidirectional(lMaterial.textProperty());
        buildingProxy.floorsProperty().bindBidirectional(lFloors.textProperty());
        buildingProxy.achitectualStyleProperty().bindBidirectional(lArchitectual.textProperty());
        buildingProxy.architectProperty().bindBidirectional(lArchitect.textProperty());
        buildingProxy.rankProperty().bindBidirectional(lRank.textProperty());
        buildingProxy.costProperty().bindBidirectional(lCost.textProperty());












    }

    public void setBuildings(ObservableList<BuildingPM> buildingsData) {
        tvBuildings.setItems(buildingsData);
    }




    @FXML
    private void handleDeleteButton(ActionEvent event) {
        int selectedIndex = tvBuildings.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tvBuildings.getItems().remove(selectedIndex);
    } else {
        // Nothing selected.
        Alert alert = new Alert(AlertType.WARNING);
        alert.initOwner(BuildingsApp.getPrimaryStage());
        alert.setTitle("No Selection");
        alert.setHeaderText("No building Selected");
        alert.setContentText("Please select a building in the table.");

        alert.showAndWait();
    }

}}
