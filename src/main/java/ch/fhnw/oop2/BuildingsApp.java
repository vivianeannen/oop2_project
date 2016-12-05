package ch.fhnw.oop2;/**
 * Created by Viviane on 26.11.2016.
 */

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ch.fhnw.oop2.controller.BuildingsAppController;
import ch.fhnw.oop2.model.BuildingPM;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// main

public class BuildingsApp extends Application {


    private static Stage primaryStage;
    private BorderPane rootLayout;

    //Separate klass
    private static final String FILE_NAME = "buildings.csv";


    private final StringProperty applicationTitle = new SimpleStringProperty("Buildings");

    private ObservableList<BuildingPM> buildingsData = FXCollections.observableArrayList();


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Buildings");

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
            BorderPane buildingsOverview = (BorderPane) loader.load();

            // Set buildings overview into the center of root layout.
            rootLayout.setCenter(buildingsOverview);


            //Loading Data   --> separate Klass

            buildingsData.setAll(readFromFile());


            // Give the controller access to the timetable.
            BuildingsAppController controller = loader.getController();
            controller.setBuildings(buildingsData);
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



    //put in separate class
    private List<BuildingPM> readFromFile() {
        try (Stream<String> stream = getStreamOfLines(FILE_NAME, true)) {
            return stream.skip(1)
                    .map(s -> new BuildingPM(s.split(";")))
                    .collect(Collectors.toList());
        }
    }

    private Stream<String> getStreamOfLines(String fileName, boolean locatedInSameFolder) {
        try {
            return Files.lines(this.getPath(fileName, locatedInSameFolder), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private Path getPath(String filename, boolean locatedInSameFolder) {
        try {
            if (!locatedInSameFolder) {
                filename = ";" + filename;
            }
            return Paths.get(this.getClass().getResource(filename).toURI());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
