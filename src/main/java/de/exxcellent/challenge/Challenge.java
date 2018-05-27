package de.exxcellent.challenge;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

public class Challenge {
    private List<ChallengeRecord> items = new ArrayList<>();

    // output key of item with smallest spread
    public String keyWithMinSpread() {
        // find item with minimal spread
        ChallengeRecord minBySpread = minBySpread(items);

        // return key
        return minBySpread.getKey();
    }

    // Read CSV file and store records as ChallengeRecord list
    public int importFromCSV(String filename, String keyLabel, String firstLabel, String secondLabel) {
        try {
            // load  csv file
            ClassLoader classLoader = getClass().getClassLoader();
            Reader in = new FileReader(classLoader.getResource(filename).getFile());

            // parse CSV-file using package org.apache.commons.csv
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);

            // map each CSVRecord to a ChallengeRecord using the Java stream API
            items = StreamSupport.stream(records.spliterator(), false)
                    .map(r -> new ChallengeRecord(r.get(keyLabel), r.get(firstLabel), r.get(secondLabel)))
                    .collect(Collectors.toList());

        } catch (IOException ex) {
            // todo: catch exception. what would be useful?
        }

        return items.size();
    }

    // Return a ChallengeRecord out of list with smallest spread abs(value1 - value2)
    // not necessarily unique if there are multiple items with identical spread
    public ChallengeRecord minBySpread(List<ChallengeRecord> items) {
        return items
                .stream()
                .min(Comparator.comparing(a -> a.spread())) // minimum in relation to spread()
                .orElseThrow(NoSuchElementException::new);
    }
}
