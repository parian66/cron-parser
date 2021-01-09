package co.uk.deliveroo.task.cron.parser;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RangeParserTest {
    private final TimeParser timeParser = new RangeParser();

    @Test
    public void testExtract() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, timeParser.extract("1-5", 1, 7));
    }
}
