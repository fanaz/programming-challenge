package de.exxcellent.challenge;

import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeatherChallengeTest {

    @Test
    public void importFromCSVTest() throws IOException {
        WeatherChallenge testChallenge = new WeatherChallenge();
        List<WeatherItem> items = testChallenge.importFromCSV();
        Assert.assertEquals(30, items.size());
    }

    @Test
    public void minBySpreadTest() {
        WeatherChallenge testChallenge = new WeatherChallenge();

        List<WeatherItem> items = new ArrayList<>();
        items.add(new WeatherItem("1","20","12"));
        items.add(new WeatherItem("1","22","14"));
        items.add(new WeatherItem("1","22","10"));

        WeatherItem minBySpread = testChallenge.minBySpread(items);

        Assert.assertEquals(8, minBySpread.getMxt()-minBySpread.getMnt());
    }
}
