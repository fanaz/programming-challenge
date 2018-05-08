package de.exxcellent.challenge;

import java.lang.Math;

public class ChallengeRecord {
    // Class to store data of one record

    // Properties
    private final String key;
    private final int value1;
    private final int value2;

    // Constructor
    public ChallengeRecord(String key, String value1, String value2) {
        this.key = key;
        this.value1 = Integer.parseInt(value1);
        this.value2 = Integer.parseInt(value2);
    }

    public String getKey() {
        return key;
    }

    public int spread() {
        return Math.abs(value1 - value2);
    }
}
