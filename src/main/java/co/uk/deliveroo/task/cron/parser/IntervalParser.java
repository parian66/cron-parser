package co.uk.deliveroo.task.cron.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

class IntervalParser extends TimeParser {
    public static final String INTERVAL_REGEX = "(\\*|\\d)\\/(\\d{1,2})";

    protected IntervalParser() {
        super(INTERVAL_REGEX);
    }

    @Override
    public int[] extract(Matcher matcher, int min, int max) {
        final int start = matcher.group(1).equals("*") ? min : Integer.parseInt(matcher.group(1));
        final int step = Integer.parseInt(matcher.group(2));

        if (start < min || start > max) {
            throw new IllegalArgumentException("start can't be lower than " + min + " or greater than " + max);
        }

        if (step == 0) {
            throw new IllegalArgumentException("step must be 0");
        }

        final List<Integer> numbers = new ArrayList<>();
        for (int i = start; i <= max; i += step) {
            numbers.add(i);
        }
        return numbers.stream().mapToInt(i -> i).toArray();
    }
}
