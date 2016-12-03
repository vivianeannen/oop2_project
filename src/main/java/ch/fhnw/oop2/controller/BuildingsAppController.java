package ch.fhnw.oop2.controller;

import ch.fhnw.oop2.BuildingsApp;
import ch.fhnw.oop2.model.BuildingPM;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        tcCity.setCellValueFactory(cellData -> cellData.getValue().cityProperty());

        tcRank.setCellValueFactory(cellData -> cellData.getValue().rankProperty());

    }

    private void showBuildingDetails(BuildingPM builing){
        if (builing != null) {
            // Fill the labels with info from the person object.
            lName.setText(builing.getName());
            lastNameLabel.setText(person.getLastName());
            streetLabel.setText(person.getStreet());
            postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
            cityLabel.setText(person.getCity());

            // TODO: We need a way to convert the birthday into a String!
            // birthdayLabel.setText(...);
        } else {
            // Person is null, remove all the text.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
            birthdayLabel.setText("");
        }
    }

    }

    public void setMain(BuildingsApp main){
        this.main=main;
    }

    public void setBuildings(ObservableList<BuildingPM> buildingsData) {
        tvBuildings.setItems(buildingsData);
    }
}
