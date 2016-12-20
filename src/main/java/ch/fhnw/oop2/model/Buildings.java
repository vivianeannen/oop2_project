package ch.fhnw.oop2.model;

import ch.fhnw.oop2.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
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
public class Buildings {

    public ObservableList<BuildingPM> buildingsData = FXCollections.observableArrayList();


    public Buildings(String list){
        buildingsData.setAll(Utils.readFromFile(list));
    }



    public ObservableList<BuildingPM> getBuildingsData(){
        return buildingsData;
    }


    // new Buildings
    public void createnewBuilding() {
        buildingsData.addAll(new BuildingPM("", "", "", "", "", "", "","","","","","","",""));

    }

}
