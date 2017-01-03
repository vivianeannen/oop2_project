package ch.fhnw.oop2;

/**
 * Created by Viviane on 26.11.2016.
 */

import java.io.IOException;

import ch.fhnw.oop2.controller.BuildingsAppController;
import ch.fhnw.oop2.model.Buildings;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// main

public class BuildingsApp extends Application {

    private static Stage primaryStage;
    private BorderPane rootLayout;

    //Separate class
    public static final String FILE_NAME = "buildings.csv";

    private final StringProperty applicationTitle = new SimpleStringProperty("Buildings");

    private Buildings buildings;

    @Override public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Buildings");

        buildings = new Buildings(FILE_NAME);
        initRootLayout();

        showBuildingsOverview();

    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(BuildingsApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showBuildingsOverview() {
        try {
            // Load buildings overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(BuildingsApp.class.getResource("view/BuildingsOverview.fxml"));
            loader.setController(BuildingsAppController.getInstance());
            BorderPane buildingsOverview = (BorderPane) loader.load();

            // Set buildings overview into the center of root layout.
            rootLayout.setCenter(buildingsOverview);

            // Give the controller access to the timetable.
            BuildingsAppController controller = BuildingsAppController.getInstance();
            controller.setBuildings(buildings.getBuildingsData());
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     *
     * @return
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Buildings getBuildings() {
        return buildings;
    }

}
