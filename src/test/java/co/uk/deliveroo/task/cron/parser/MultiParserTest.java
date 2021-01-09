package co.uk.deliveroo.task.cron.parser;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MultiParserTest {
    private final TimeParser timeParser = new MultiParser();

    @Test
    public void testExtract() {
        assertArrayEquals(new int[]{1, 5, 7}, timeParser.extract("1,5,7", 1, 7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExtract_lessThanMin() {
        timeParser.extract("0,5", 1, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExtract_greaterThanMax() {
        timeParser.extract("1,5,8", 1, 7);
    }
}
