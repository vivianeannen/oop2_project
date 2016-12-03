package ch.fhnw.oop2.controller;

import ch.fhnw.oop2.BuildingsApp;
import ch.fhnw.oop2.model.BuildingPM;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by norinasteiner on 01.12.16.
 */
public class BuildingsAppController implements Initializable {
    public BuildingsApp main;

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
    private Label lCity;
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

    private void showBuildingDetails(BuildingPM builing) {
        if (builing != null) {
            // Fill the labels with info from the person object.
            lName.setText(builing.getName());
            lCity.setText(builing.getCity());
            lHeightm.setText(builing.getHeightM());
            lFloors.setText(builing.getFloors());
            lArchitect.setText(builing.getArchitect());
            lCost.setText(builing.getCost());
            lLongitude.setText(builing.getLongitude());
            lCountry.setText(builing.getCountry());
            lHeightft.setText(builing.getHeightFT());
            lBuild.setText(builing.getBuild());
            lArchitectual.setText(builing.getAchitectualStyle());
            lMaterial.setText(builing.getMaterlial());
            lLatitude.setText(builing.getLatitude());
            lRank.setText(builing.getRank());
            laHeightm.setText(builing.getHeightM());
            laCity.setText(builing.getCity());
            laName.setText(builing.getName());

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
    }

    public void setBuildings(ObservableList<BuildingPM> buildingsData) {
        tvBuildings.setItems(buildingsData);
    }


    @FXML
    private void handleDeleteBuilding() {
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
