package co.uk.deliveroo.task.cron.parser;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingeParserTest {
    private final TimeParser timeParser = new SingeParser();

    @Test
    public void testExtract() {
        assertArrayEquals(new int[]{10}, timeParser.extract("10", 1, 12));
    }
}
