package co.uk.deliveroo.task.cron.parser;

import java.util.regex.Matcher;
import java.util.stream.IntStream;

class RangeParser extends TimeParser {
    public static final String RANGE_REGEX = "(\\d{1,2})\\-(\\d{1,2})";

    protected RangeParser() {
        super(RANGE_REGEX);
    }

    @Override
    public int[] extract(Matcher matcher, int min, int max) {
        final int start = Integer.parseInt(matcher.group(1));
        final int end = Integer.parseInt(matcher.group(2));

        if (start < min) {
            throw new IllegalArgumentException("start can't be lower than" + min);
        }
        if (end > max) {
            throw new IllegalArgumentException("end can't be greater than" + max);
        }

        return IntStream.rangeClosed(start, end).toArray();
    }
}
