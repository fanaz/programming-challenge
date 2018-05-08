package de.exxcellent.challenge;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) {

        // Weather challenge
        Challenge weather = new Challenge();
        weather.importFromCSV("de/exxcellent/challenge/weather.csv","Day", "MxT", "MnT");
        String dayWithSmallestTempSpread = weather.keyWithMinSpread();

        // Football challenge
        Challenge football = new Challenge();
        football.importFromCSV("de/exxcellent/challenge/football.csv","Team", "Goals", "Goals Allowed");
        String teamWithSmallesGoalSpread = football.keyWithMinSpread();

        // Output
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}
