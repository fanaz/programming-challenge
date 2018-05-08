package de.exxcellent.challenge;

import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChallengeTest {

    @Test
    public void importFromCSVTest() throws IOException {
        Challenge testChallenge = new Challenge();
        List<ChallengeRecord> items = testChallenge.importFromCSV();
        Assert.assertEquals(30, items.size());
    }

    @Test
    public void minBySpreadTest() {
        Challenge testChallenge = new Challenge();

        List<ChallengeRecord> items = new ArrayList<>();
        items.add(new ChallengeRecord("1","20","12"));
        items.add(new ChallengeRecord("1","22","14"));
        items.add(new ChallengeRecord("1","22","10"));

        ChallengeRecord minBySpread = testChallenge.minBySpread(items);

        Assert.assertEquals(8, minBySpread.getMxt()-minBySpread.getMnt());
    }
}
