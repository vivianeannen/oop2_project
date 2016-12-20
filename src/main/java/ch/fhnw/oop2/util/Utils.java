package ch.fhnw.oop2.util;

/**
 * Created by norinasteiner on 17.12.16.
 */

import ch.fhnw.oop2.BuildingsApp;
import ch.fhnw.oop2.model.BuildingPM;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ernst on 26.04.2016.
 */

public class Utils {
    /**
     * Returns the WHOLE CSV as a List<List<String>>, first entry are headers of the csv
     *
     * @param file
     * @param seperator
     * @return List<List<String>>
     */
    public static List<List<String>> readCSV(File file, String seperator) {
        try {
            return Files.lines(file.toPath(), StandardCharsets.UTF_8).map(line -> Arrays.asList(line.split(seperator)))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Create a csv String with a given seperator
     *
     * @param data
     * @param seperator
     * @return String
     */
    public static String createCSVString(List<List<String>> data, final String seperator) {
        List<String> csv = new ArrayList<>();
        data.forEach(line -> csv.add(line.stream().
                reduce((t, u) -> t + seperator + u).
                get() + seperator));
        StringBuilder csvString = new StringBuilder();
        for (String line : csv) {
            csvString.append(line);
            csvString.append("\n");
        }
        return csvString.toString();
    }

    public static List<BuildingPM> readFromFile(String filename) {
        try (Stream<String> stream = getStreamOfLines(filename, true)) {
            return stream.skip(1).map(s -> new BuildingPM(s.split(";"))).collect(Collectors.toList());
        }
    }

    public static Stream<String> getStreamOfLines(String fileName, boolean locatedInSameFolder) {
        try {
            return Files.lines(getPath(fileName, locatedInSameFolder), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Path getPath(String filename, boolean locatedInSameFolder) {
        try {
            if (!locatedInSameFolder) {
                filename = ";" + filename;
            }
            return Paths.get(BuildingsApp.class.getResource(filename).toURI());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static double footToMeter(double foot){
        return foot * 0.3048;
    }

    public static double meterToFoot(double meter){
        return meter / 0.3048;
    }
}
