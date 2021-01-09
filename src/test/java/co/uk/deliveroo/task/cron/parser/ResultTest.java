package co.uk.deliveroo.task.cron.parser;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResultTest {
    @Test
    public void testPrint() {
        final Result result = new Result(
                new int[]{0, 15, 30, 45},
                new int[]{0},
                new int[]{1, 15},
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
                new int[]{1, 2, 3, 4, 5},
                "/usr/bin/find"
        );
        final String expected = "minute        0 15 30 45\n" +
                "hour          0\n" +
                "day of month  1 15\n" +
                "month         1 2 3 4 5 6 7 8 9 10 11 12\n" +
                "day of week   1 2 3 4 5\n" +
                "command       /usr/bin/find";
        Assert.assertEquals(expected, result.print());
    }
}
