package co.uk.deliveroo.task.cron.parser;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class IntervalParserTest {
    private final TimeParser timeParser = new IntervalParser();

    @Test
    public void testExtract() {
        assertArrayEquals(new int[]{0, 15, 30, 45}, timeParser.extract("*/15", 0, 59));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, timeParser.extract("1/1", 1, 5));
        assertArrayEquals(new int[]{1, 3, 5}, timeParser.extract("1/2", 1, 5));
        assertArrayEquals(new int[]{2, 4}, timeParser.extract("2/2", 1, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExtract_zeroStep() {
        timeParser.extract("*/0", 0, 59);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExtract_withStartLowerThanMin() {
        timeParser.extract("0/1", 1, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExtract_withStartGreaterThanMax() {
        timeParser.extract("7/1", 1, 5);
    }
}
