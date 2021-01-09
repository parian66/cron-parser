package co.uk.deliveroo.task.cron.parser;

import org.junit.Test;

import static org.junit.Assert.*;

public class StarParserTest {
    private final TimeParser timeParser = new StarParser();

    @Test
    public void testExtract() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, timeParser.extract("*", 1, 7));
    }
}
