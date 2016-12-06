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




    //@FXML

    @FXML
    private TableView<BuildingPM> tvBuildings;

    @FXML
    private TableColumn<BuildingPM, String> tcName;
    @FXML
    private TableColumn<BuildingPM, String> tcCity;
    @FXML
    private TableColumn<BuildingPM, String> tcRank;
    @FXML
    private Label lName;
    @FXML
    private TextField lCity;
    @FXML
    private Label lHeightm;
    @FXML
    private Label lFloors;
    @FXML
    private Label lArchitect;
    @FXML
    private Label lCost;
    @FXML
    private Label lLongitude;
    @FXML
    private Label lCountry;
    @FXML
    private Label lHeightft;
    @FXML
    private Label lBuild;
    @FXML
    private Label lArchitectual;
    @FXML
    private Label lMaterial;
    @FXML
    private Label lLatitude;
    @FXML
    private Label lRank;
    @FXML
    private Label laName;
    @FXML
    private Label laCity;
    @FXML
    private Label laHeightm;


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
            // Fill the labels with info from the person object.
            lCity.textProperty().bindBidirectional(building.cityProperty());
            lName.setText(building.getName());
            lCity.setText(building.getCity());
            lHeightm.setText(building.getHeightM());
            lFloors.setText(building.getFloors());
            lArchitect.setText(building.getArchitect());
            lCost.setText(building.getCost());
            lLongitude.setText(building.getLongitude());
            lCountry.setText(building.getCountry());
            lHeightft.setText(building.getHeightFT());
            lBuild.setText(building.getBuild());
            lArchitectual.setText(building.getAchitectualStyle());
            lMaterial.setText(building.getMaterlial());
            lLatitude.setText(building.getLatitude());
            lRank.setText(building.getRank());
            laHeightm.setText(building.getHeightM());
            //laCity.setText(building.getCity());
            laName.setText(building.getName());
            //building.cityProperty().bind(lCity.textProperty());

        }


    else {
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
    }

    public void setBuildings(ObservableList<BuildingPM> buildingsData) {
        tvBuildings.setItems(buildingsData);
    }

    //sets the person to be edited in the dialog.

    public void setBuildingPM(BuildingPM buildingPM){
        this.buildingPM = buildingPM;

        laCity.textProperty().bind(lCity.textProperty());

        //lCity.setText(buildingPM.getCity());

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
