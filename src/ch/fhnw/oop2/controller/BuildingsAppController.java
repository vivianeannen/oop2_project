package ch.fhnw.oop2.controller;

import ch.fhnw.oop2.BuildingsApp;
import ch.fhnw.oop2.model.Buildings;
import ch.fhnw.oop2.model.BuildingPM;
import ch.fhnw.oop2.model.BuildingProxy;
import ch.fhnw.oop2.util.JavaFxUtils;
import ch.fhnw.oop2.util.Utils;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;

import static ch.fhnw.oop2.BuildingsApp.FILE_NAME;

/**
 * Created by norinasteiner on 01.12.16.
 */
public class BuildingsAppController implements Initializable {

    //***attributes***

    public BuildingsApp main;
    private ResourceBundle bundle;
    private BuildingPM buildingPM;
    private BuildingProxy buildingProxy = new BuildingProxy();
    private Buildings buildings;

    @FXML public TableView<BuildingPM> tvBuildings;
    @FXML public TableColumn<BuildingPM, String> tcName;
    @FXML public TableColumn<BuildingPM, String> tcCity;
    @FXML public TableColumn<BuildingPM, String> tcRank;
    @FXML public TextField lName;
    @FXML public TextField lCity;
    @FXML public TextField lHeightm;
    @FXML public TextField lFloors;
    @FXML public TextField lArchitect;
    @FXML public TextField lCost;
    @FXML public TextField lLongitude;
    @FXML public TextField lCountry;
    @FXML public TextField lHeightft;
    @FXML public TextField lBuild;
    @FXML public TextField lArchitectual;
    @FXML public TextField lMaterial;
    @FXML public TextField lLatitude;
    @FXML public TextField lFilter;
    @FXML public Label lRank;
    @FXML public Label laName;
    @FXML public Label laCity;
    @FXML public Label laHeightm;

    private static BuildingsAppController singleton;

    public static BuildingsAppController getInstance() {
        if (singleton == null) {
            singleton = new BuildingsAppController();
        }
        return singleton;
    }

    private BuildingsAppController() {
        //private for singleton
    }

    /**
     * initialize
     *
     * @param location
     * @param resources
     */

    @Override public void initialize(URL location, ResourceBundle resources) {
        tcName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        tcCity.setCellValueFactory(cellData -> cellData.getValue().cityProperty());

        tcRank.setCellValueFactory(cellData -> cellData.getValue().rankProperty());

        // Clear buildings details.
        showBuildingDetails(null);
        // Listen for selection changes and show the buildings details when changed.
        tvBuildings.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            showBuildingDetails(newValue);
            setRanking(buildings);
        });

        lHeightm.textProperty().addListener((observable, oldValue, newValue) -> {
            if (edited == false && !newValue.isEmpty()) {
                edited = true;
                String newHeight = Double.toString(Utils.meterToFoot(Double.valueOf(newValue)));
                lHeightft.textProperty().setValue(newHeight);
                edited = false;
            }
        });

        lHeightft.textProperty().addListener((observable, oldValue, newValue) -> {
            if (edited == false && !newValue.isEmpty()) {
                edited = true;
                String newHeight = Double.toString(Utils.footToMeter(Double.valueOf(newValue)));
                lHeightm.textProperty().setValue(newHeight);
                edited = false;
            }
        });
        JavaFxUtils.addFilter_OnlyNumbers(lHeightm);
        JavaFxUtils.addFilter_OnlyNumbers(lHeightft);
    }

    static boolean edited = false;

    /**
     * methods
     *
     * @param building
     */
    private void showBuildingDetails(BuildingPM building) {
        if (building != null)

        {
            buildingProxy.set(building);
        } else

        {
            // Buildings is null, remove all the text.

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
        buildingProxy.materialProperty().bindBidirectional(lMaterial.textProperty());
        buildingProxy.floorsProperty().bindBidirectional(lFloors.textProperty());
        buildingProxy.architectualStyleProperty().bindBidirectional(lArchitectual.textProperty());
        buildingProxy.architectProperty().bindBidirectional(lArchitect.textProperty());
        buildingProxy.rankProperty().bindBidirectional(lRank.textProperty());
        buildingProxy.costProperty().bindBidirectional(lCost.textProperty());

        this.buildings = main.getBuildings();

    }

    public void setBuildings(ObservableList<BuildingPM> buildingsData) {
        FilteredList<BuildingPM> filteredData = new FilteredList<>(buildingsData, p -> true);
        lFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(building -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                return building.getName().toLowerCase().contains(lowerCaseFilter) || building.getCity().toLowerCase()
                        .contains(lowerCaseFilter) || building.getRank().toLowerCase().contains(lowerCaseFilter)
                        || building.getHeightM().toLowerCase().contains(lowerCaseFilter) || building.getHeightFT()
                        .toLowerCase().contains(lowerCaseFilter) || building.getCost().toLowerCase()
                        .contains(lowerCaseFilter) || building.getCountry().toLowerCase().contains(lowerCaseFilter)
                        || building.getLongitude().toLowerCase().contains(lowerCaseFilter) || building.getLatitude()
                        .toLowerCase().contains(lowerCaseFilter) || building.getBuild().toLowerCase()
                        .contains(lowerCaseFilter) || building.getArchitect().toLowerCase().contains(lowerCaseFilter)
                        || building.getArchitectualStyle().toLowerCase().contains(lowerCaseFilter) || building
                        .getMaterial().toLowerCase().contains(lowerCaseFilter);

            });
        });

        tvBuildings.setItems(filteredData);
    }

    /**
     * Event Handling
     *
     * @param event
     */
    @FXML private void handleDeleteButton(ActionEvent event) {
        int selectedIndex = tvBuildings.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tvBuildings.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(BuildingsApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No buildings Selected");
            alert.setContentText("Please select a buildings in the table.");

            alert.showAndWait();
        }

    }

    @FXML public void handleNewButton() {
        //        String[]newLine = {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
        //        BuildingPM newBuilding = new BuildingPM(newLine);
        //        buildings.addAll(newBuilding);
        //        setSelectedBuilding(newBuilding);
        buildings.createnewBuilding();
        tvBuildings.getSelectionModel().selectLast();
        tvBuildings.scrollTo(tvBuildings.getItems().size() - 1);

    }

    @FXML public void handleSaveButton() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Utils.loadFile(FILE_NAME)))) {
            writer.write(
                    "id;rank;name;city;country;heightM;heightFT;floors;build;architect;architectual;cost;material;longitude;latitude");
            writer.newLine();
            buildings.buildingsData.stream().forEach(o1 -> {
                try {
                    writer.write(o1.getId() + ";" + o1.getRank() + ";" + o1.getName() + ";" + o1.getCity() + ";" + o1
                            .getCountry() + ";" + o1.getHeightM() + ";" + o1.getHeightFT() + ";" + o1.getFloors() + ";"
                            + o1.getBuild() + ";" + o1.getArchitect() + ";" + o1.getArchitectualStyle() + ";" + o1
                            .getCost() + ";" + o1.getMaterial() + ";" + o1.getLongitude() + ";" + o1.getLatitude());
                    writer.newLine();
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            });
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new IllegalStateException("saving failed!");
        }

    }

    @FXML public void handleUndoButton() {
        UndoRedoHandler.getInstance().undo();
    }

    @FXML public void handleRedoButton() {
        UndoRedoHandler.getInstance().redo();
    }

    //doppelt??

    //    @FXML public void add(ActionEvent actionEvent) {
    //        buildings.createnewBuilding();
    //        tvBuildings.getSelectionModel().selectLast();
    //        tvBuildings.scrollTo(tvBuildings.getItems().size() - 1);
    //    }

    private void setRanking(Buildings buildings) {
        buildings.buildingsData.stream().filter(data -> data.getHeightM() != "").
                sorted((o1, o2) -> (int) (Double.valueOf(o2.getHeightM()) - Double.valueOf(o1.getHeightM())));
/*        Collections.sort(buildings.buildingsData,
                (o1, o2) -> (int) (Double.valueOf(o2.getHeightM()) - Double.valueOf(o1.getHeightM())));*/

        for (int i = 0; i < buildings.buildingsData.size(); i++) {
            buildings.buildingsData.get(i).setRank("" + (i + 1));
        }

    }

}
