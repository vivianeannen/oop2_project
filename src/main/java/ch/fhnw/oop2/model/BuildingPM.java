package ch.fhnw.oop2.model;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
//import javafx.scene.shape.Path;


import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;


import java.nio.charset.StandardCharsets;



// Alles muss String sein in einer Tabelle

/**
 * Created by norinasteiner on 26.11.16.
 */
public class BuildingPM {


    private StringProperty name = new SimpleStringProperty();
    private StringProperty city = new SimpleStringProperty();
    private DoubleProperty heightM = new SimpleDoubleProperty();
    private IntegerProperty floors = new SimpleIntegerProperty();
    private StringProperty rank = new SimpleStringProperty();
    private StringProperty architect = new SimpleStringProperty();
    private DoubleProperty cost = new SimpleDoubleProperty();
    private DoubleProperty longitude = new SimpleDoubleProperty();
    private StringProperty country = new SimpleStringProperty();
    private DoubleProperty heightFT = new SimpleDoubleProperty();
    private IntegerProperty build = new SimpleIntegerProperty();
    private StringProperty achitectualStyle = new SimpleStringProperty();
    private StringProperty materlial = new SimpleStringProperty();
    private DoubleProperty latitude = new SimpleDoubleProperty();


    public BuildingPM(String name, String city, double heightM, int floors, String architect, double cost, double longitude,
                      String county, double heightFT, int build, int rank, String achitectualStyle, String material, double latitude) {
        // this.setName(name); so sollte es glaub sein
      /*  this.name = new SimpleStringProperty(name);
        this.city = new SimpleStringProperty(city);
        this.architect = new SimpleStringProperty(architect);
        this.country = new SimpleStringProperty(county);
        this.achitectualStyle = new SimpleStringProperty(achitectualStyle);
        this.materlial = new SimpleStringProperty(material);
        this.heightM = new SimpleDoubleProperty(heightM);
        this.heightFT = new SimpleDoubleProperty(heightFT);
        this.cost = new SimpleDoubleProperty(cost);
        this.longitude = new SimpleDoubleProperty(longitude);
        this.latitude = new SimpleDoubleProperty(latitude);
        this.floors = new SimpleIntegerProperty(floors);
        this.build = new SimpleIntegerProperty(build);
        this.rank = new SimpleIntegerProperty(rank);

*/
    }


    public BuildingPM(String[] line) {
        this.setRank(line[1]);
        this.setName(line[2]);
        this.setCity(line[3]);
        this.setCountry(line[4]);
        this.setHeightM(Double.valueOf(line[5]));
        this.setHeightFT(Double.valueOf(line[6]));
        this.setFloors(Integer.valueOf(line[7]));
        this.setBuild(Integer.valueOf(line[8]));
        this.setArchitect(line[9]);
        this.setAchitectualStyle(line[10]);
        this.setCost(Double.valueOf(line[11]));
        this.setMaterlial(line[12]);
        this.setLongitude(Double.valueOf(line[13]));
        this.setLatitude(Double.valueOf(line[14]));

    }


    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public double getHeightM() {
        return heightM.get();
    }

    public DoubleProperty heightMProperty() {
        return heightM;
    }

    public void setHeightM(double heightM) {
        this.heightM.set(heightM);
    }

    public int getFloors() {
        return floors.get();
    }

    public IntegerProperty floorsProperty() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors.set(floors);
    }

    public String getArchitect() {
        return architect.get();
    }

    public StringProperty architectProperty() {
        return architect;
    }

    public void setArchitect(String architect) {
        this.architect.set(architect);
    }

    public double getCost() {
        return cost.get();
    }

    public DoubleProperty costProperty() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost.set(cost);
    }

    public double getLongitude() {
        return longitude.get();
    }

    public DoubleProperty longitudeProperty() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude.set(longitude);
    }

    public String getCountry() {
        return country.get();
    }

    public StringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public double getHeightFT() {
        return heightFT.get();
    }

    public DoubleProperty heightFTProperty() {
        return heightFT;
    }

    public void setHeightFT(double heightFT) {
        this.heightFT.set(heightFT);
    }

    public int getBuild() {
        return build.get();
    }

    public IntegerProperty buildProperty() {
        return build;
    }

    public void setBuild(int build) {
        this.build.set(build);
    }

    public String getAchitectualStyle() {
        return achitectualStyle.get();
    }

    public StringProperty achitectualStyleProperty() {
        return achitectualStyle;
    }

    public void setAchitectualStyle(String achitectualStyle) {
        this.achitectualStyle.set(achitectualStyle);
    }

    public String getMaterlial() {
        return materlial.get();
    }

    public StringProperty materlialProperty() {
        return materlial;
    }

    public void setMaterlial(String materlial) {
        this.materlial.set(materlial);
    }

    public double getLatitude() {
        return latitude.get();
    }

    public DoubleProperty latitudeProperty() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude.set(latitude);
    }


    public String getRank() {
        return rank.get();
    }

    public StringProperty rankProperty() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank.set(rank);
    }
}
