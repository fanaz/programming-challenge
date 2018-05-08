package de.exxcellent.challenge;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Challenge {

    // output day number with smallest spread
    public int dayWithMinSpread() {
        List<ChallengeRecord> items = new ArrayList<>();

        // import file
        try {
            items = importFromCSV();

        } catch (IOException ex) {
            System.out.printf(ex.getMessage());
        }

        // find item with minimal spread
        ChallengeRecord minBySpread = minBySpread(items);

        // return day
        return minBySpread.getDay();
    }

    // Read CSV file and store records as ChallengeRecord list
    public List<ChallengeRecord> importFromCSV() throws IOException {

        // empty list
        List<ChallengeRecord> items = new ArrayList<>();

        // load weather.csv
        ClassLoader classLoader = getClass().getClassLoader();
        Reader in = new FileReader(classLoader.getResource("de/exxcellent/challenge/weather.csv").getFile());

        // parse CSV-file using package org.apache.commons.csv
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {
            String day = record.get("Day");
            String mxt = record.get("MxT");
            String mnt = record.get("MnT");

            // add data to list
            items.add(new ChallengeRecord(day, mxt, mnt));
        }

        return items;
    }

    // Return a ChallengeRecord out of list with smallest spread (MxT - MnT)
    // not necessarily unique if there are multiple items with identical spread
    public ChallengeRecord minBySpread(List<ChallengeRecord> items) {
        return items
                .stream()
                .min(Comparator.comparing(a -> a.getMxt() - a.getMnt()))
                .orElseThrow(NoSuchElementException::new);
    }
}
