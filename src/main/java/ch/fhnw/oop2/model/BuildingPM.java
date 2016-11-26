package ch.fhnw.oop2.model;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.time.LocalDate;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Path;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;


import java.nio.charset.StandardCharsets;


/**
 * Created by norinasteiner on 26.11.16.
 */
public class BuildingPM {


    private StringProperty name;
    private StringProperty city;
    private DoubleProperty heightM;
    private IntegerProperty floors;
    private IntegerProperty rank;
    private StringProperty architect;
    private DoubleProperty cost;
    private DoubleProperty longitude;
    private StringProperty country;
    private DoubleProperty heightFT;
    private IntegerProperty build;
    private StringProperty achitectualStyle;
    private StringProperty materlial;
    private DoubleProperty latitude;

    private static final String FILE_NAME = "buildings.csv";
    private static final String TAB = "\\t";


    private final StringProperty applicationTitle = new SimpleStringProperty("Buildings");

    private ObservableList <BuildingPM> buildingsData = FXCollections.observableArrayList();



    public BuildingPM(String name, String city, double heightM, int floors, String architect, double cost, double longitude,
                      String county, double heightFT, int build, int rank, String achitectualStyle, String material, double latitude) {
        this.name = new SimpleStringProperty(name);
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

    }




    private List<BuildingPM> readFromFile() { 
        try (Stream<String> stream = getStreamOfLines(FILE_NAME, true)) { return stream.skip(1)
                .map(s -> new BuildingPM(s.split(TAB)))
                .collect(Collectors.toList());     } }

    private Stream<String> getStreamOfLines(String fileName, boolean locatedInSameFolder) { try { 
        return Files.lines(this.getPath(fileName, locatedInSameFolder), StandardCharsets.UTF_8); } catch (IOException e) { 
        throw new IllegalStateException(e); } }

    private Path getPath(String filename, boolean locatedInSameFolder) { 
        try { if (!locatedInSameFolder) { filename = "\\t" + filename; } 
            return Paths.get(this.getClass().getResource(filename).toURI()); } catch (URISyntaxException e) { 
            throw new IllegalArgumentException(e); } }


    public BuildingPM(String[] line) {
        this.setRank(Integer.valueOf(line[1]).intValue());
        this.setName(line[2]);
        this.setCity(line[3]);
        this.setCountry(line[4]);
        this.setHeightM(Double.valueOf(line[5]).doubleValue());
        this.setHeightFT(Double.valueOf(line[6]).doubleValue());
        this.setFloors(Integer.valueOf(line[7]));
        this.setBuild(Integer.valueOf(line[8]).intValue());
        this.setArchitect(line[9]);
        this.setAchitectualStyle(line[10]);
        this.setCost(Double.valueOf(line[11]).doubleValue());
        this.setMaterlial(line[12]);
        this.setLongitude(Double.valueOf(line[13]).doubleValue());
        this.setLatitude(Double.valueOf(line[14]).doubleValue());

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


    public int getRank() {
        return rank.get();
    }

    public IntegerProperty rankProperty() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank.set(rank);
    }

    public static String getFileName() {
        return FILE_NAME;
    }

    public static String getTAB() {
        return TAB;
    }

    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle.set(applicationTitle);
    }

    public ObservableList<BuildingPM> getBuildingsData() {
        return buildingsData;
    }

    public void setBuildingsData(ObservableList<BuildingPM> buildingsData) {
        this.buildingsData = buildingsData;
    }
}
