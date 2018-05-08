package de.exxcellent.challenge;

public class ChallengeRecord {
    // Class to store data of one record

    // Properties
    private final int key;
    private final int value1;
    private final int value2;

    // Constructor
    public ChallengeRecord(String key, String value1, String value2) {
        this.key = Integer.parseInt(key);
        this.value1 = Integer.parseInt(value1);
        this.value2 = Integer.parseInt(value2);
    }

    public int getKey() {
        return key;
    }

    public int spread() {
        return value1 - value2;
    }
}
