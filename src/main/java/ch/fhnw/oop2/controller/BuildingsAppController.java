package ch.fhnw.oop2.controller;

import ch.fhnw.oop2.BuildingsApp;
import ch.fhnw.oop2.model.BuildingPM;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        tcCity.setCellValueFactory(cellData -> cellData.getValue().cityProperty());

        tcRank.setCellValueFactory(cellData -> cellData.getValue().rankProperty());

    }

    public void setMain(BuildingsApp main){
        this.main=main;
    }

    public void setBuildings(ObservableList<BuildingPM> buildingsData) {
        tvBuildings.setItems(buildingsData);
    }
}
