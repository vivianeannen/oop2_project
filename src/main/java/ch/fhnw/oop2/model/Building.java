package ch.fhnw.oop2.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by norinasteiner on 17.12.16.
 */
public class Building {

    public ObservableList<BuildingPM> buildingsData = FXCollections.observableArrayList();


    public Building (String list){
        buildingsData.setAll(readFromFile(list));
    }

    //put in separate class
    private List<BuildingPM> readFromFile(String filename) {
        try (Stream<String> stream = getStreamOfLines(filename, true)) {
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

    public ObservableList<BuildingPM> getBuildingsData(){
        return buildingsData;
    }


    // new Building

    // new
    public void createnewBuilding() {
        buildingsData.addAll(new BuildingPM("", "", "", "", "", "", "","","","","","","",""));

    }


}
