package ch.fhnw.oop2;

/**
 * Created by Viviane on 26.11.2016.
 */

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import ch.fhnw.oop2.controller.BuildingsAppController;
import ch.fhnw.oop2.model.Buildings;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

// main

public class BuildingsApp extends Application {

	private static Stage stage;


	//Separate class
	public static final String FILE_NAME = "buildings.csv";

	private final StringProperty applicationTitle = new SimpleStringProperty("Buildings");

	private Buildings buildings;

	@Override
	public void start(Stage primaryStage) {
		this.stage = primaryStage;
		this.stage.setTitle("Buildings");

		buildings = new Buildings(FILE_NAME);

		Button btnEN = new Button();
		btnEN.setText("English");
		btnEN.setOnAction((event) -> {
					loadView(new Locale("en", "EN"));
				}
		);

		Button btnDE = new Button();
		btnDE.setText("Deutsch");
		btnDE.setOnAction((event) -> {
					loadView(new Locale("de", "DE"));
				}
		);

		VBox root = new VBox(20);
		root.getChildren().add(HBoxBuilder.create().spacing(5).style("-fx-background-color: white").padding(new Insets(5)).children(btnEN, btnDE).build());
		root.getChildren().add(new StackPane());
		primaryStage.setScene(new Scene(root, 800, 500));
		primaryStage.getScene().getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		primaryStage.show();

		//showBuildingsOverview();

	}

	/**
	 * Initializes the root layout.
	 */
	public void loadView(Locale locale) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			//Load locale file
			fxmlLoader.setResources(ResourceBundle.getBundle("Bundle", locale));
			// Load root layout from fxml file.

			Pane pane = (BorderPane) fxmlLoader.load(this.getClass().getResource("view/BuildingsOverview.fxml").openStream());

			// replace the content
			StackPane content = (StackPane) ((VBox) stage.getScene().getRoot()).getChildren().get(1);
			content.getChildren().clear();
			content.getChildren().add(pane);

			// Give the controller access.
			BuildingsAppController controller = fxmlLoader.getController();
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
		return stage;
	}

	public static void main(String[] args) {
		launch(args);
	}

	public Buildings getBuildings() {
		return buildings;
	}

}
