package de.exxcellent.challenge;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class WeatherChallenge {

    public List<WeatherItem> importFromCSV() throws IOException {

        // empty list
        List<WeatherItem> items = new ArrayList<>();

        // load weather.csv
        ClassLoader classLoader = getClass().getClassLoader();
        Reader in = new FileReader(classLoader.getResource("weather.csv").getFile());

        // parse CSV-file using package org.apache.commons.csv
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {
            String day = record.get("Day");
            String mxt = record.get("MxT");
            String mnt = record.get("MnT");

            // add data to list
            items.add(new WeatherItem(day, mxt, mnt));
        }

        return items;
    }
}
