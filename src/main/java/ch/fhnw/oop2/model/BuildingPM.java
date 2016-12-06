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
    private StringProperty heightM = new SimpleStringProperty();
    private StringProperty floors = new SimpleStringProperty();
    private StringProperty rank = new SimpleStringProperty();
    private StringProperty architect = new SimpleStringProperty();
    private StringProperty cost = new SimpleStringProperty();
    private StringProperty longitude = new SimpleStringProperty();
    private StringProperty country = new SimpleStringProperty();
    private StringProperty heightFT = new SimpleStringProperty();
    private StringProperty build = new SimpleStringProperty();
    private StringProperty achitectualStyle = new SimpleStringProperty();
    private StringProperty materlial = new SimpleStringProperty();
    private StringProperty latitude = new SimpleStringProperty();

    public BuildingPM(){
    }

    public BuildingPM(String name, String city, String heightM,
                      String floors, String rank, String architect, String cost,
                      String longitude, String country, String heightFT, String build,
                      String achitectualStyle, String material, String latitude) {
        this.name = new SimpleStringProperty(name);
        this.city = new SimpleStringProperty(city);
        this.heightM = new SimpleStringProperty(heightM);
        this.floors = new SimpleStringProperty(floors);
        this.rank = new SimpleStringProperty(rank);
        this.architect = new SimpleStringProperty(architect);
        this.cost = new SimpleStringProperty(cost);
        this.longitude = new SimpleStringProperty(longitude);
        this.country = new SimpleStringProperty(country);
        this.heightFT = new SimpleStringProperty(heightFT);
        this.build = new SimpleStringProperty(build);
        this.achitectualStyle = new SimpleStringProperty(achitectualStyle);
        this.materlial = new SimpleStringProperty(material);
        this.latitude = new SimpleStringProperty(latitude);
    }

    public BuildingPM(String[] line) {
        this.setRank(line[1]);
        this.setName(line[2]);
        this.setCity(line[3]);
        this.setCountry(line[4]);
        this.setHeightM(line[5]);
        this.setHeightFT(line[6]);
        this.setFloors(line[7]);
        this.setBuild(line[8]);
        this.setArchitect(line[9]);
        this.setAchitectualStyle(line[10]);
        this.setCost(line[11]);
        this.setMaterlial(line[12]);
        this.setLongitude(line[13]);
        this.setLatitude(line[14]);

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

    public String getHeightM() {
        return heightM.get();
    }

    public StringProperty heightMProperty() {
        return heightM;
    }

    public void setHeightM(String heightM) {
        this.heightM.set(heightM);
    }

    public String getFloors() {
        return floors.get();
    }

    public StringProperty floorsProperty() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors.set(floors);
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

    public String getArchitect() {
        return architect.get();
    }

    public StringProperty architectProperty() {
        return architect;
    }

    public void setArchitect(String architect) {
        this.architect.set(architect);
    }

    public String getCost() {
        return cost.get();
    }

    public StringProperty costProperty() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost.set(cost);
    }

    public String getLongitude() {
        return longitude.get();
    }

    public StringProperty longitudeProperty() {
        return longitude;
    }

    public void setLongitude(String longitude) {
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

    public String getHeightFT() {
        return heightFT.get();
    }

    public StringProperty heightFTProperty() {
        return heightFT;
    }

    public void setHeightFT(String heightFT) {
        this.heightFT.set(heightFT);
    }

    public String getBuild() {
        return build.get();
    }

    public StringProperty buildProperty() {
        return build;
    }

    public void setBuild(String build) {
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

    public String getLatitude() {
        return latitude.get();
    }

    public StringProperty latitudeProperty() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude.set(latitude);
    }
}

