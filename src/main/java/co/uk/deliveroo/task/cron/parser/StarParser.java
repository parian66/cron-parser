package co.uk.deliveroo.task.cron.parser;

import java.util.regex.Matcher;
import java.util.stream.IntStream;

class StarParser extends TimeParser {
    public static final String ALL_REGEX = "\\*";

    protected StarParser() {
        super(ALL_REGEX);
    }

    @Override
    public int[] extract(Matcher matcher, int min, int max) {
        return IntStream.rangeClosed(min, max).toArray();
    }
}
