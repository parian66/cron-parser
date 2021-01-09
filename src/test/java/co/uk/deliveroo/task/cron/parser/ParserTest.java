package co.uk.deliveroo.task.cron.parser;

import org.junit.Assert;
import org.junit.Test;

public class ParserTest {

    private final Parser parser = new Parser();

    @Test
    public void testIsValid() {
        parser.pars("*/15 0 1,15 * 1-5 /usr/bin/find");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsNotValid_null() {
        parser.pars(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsNotValid_blank() {
        parser.pars("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsNotValid_missingCommand() {
        parser.pars("*/15 0 1,15 * 1-5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsNotValid_missingMinute() {
        parser.pars("0 1,15 * 1-5 /usr/bin/find");
    }

    @Test
    public void testPars() {
        final Result expected = new Result(
                new int[]{0, 15, 30, 45},
                new int[]{0},
                new int[]{1, 15},
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
                new int[]{1, 2, 3, 4, 5},
                "/usr/bin/find"
        );

        Assert.assertEquals(expected, parser.pars("*/15 0 1,15 * 1-5 /usr/bin/find"));
    }
}
