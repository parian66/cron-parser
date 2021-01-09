package co.uk.deliveroo.task.cron.parser;

import java.util.regex.Matcher;

class SingeParser extends TimeParser {
    public static final String SINGLE_REGEX = "(\\d{1,2})";

    protected SingeParser() {
        super(SINGLE_REGEX);
    }

    @Override
    public int[] extract(Matcher matcher, int min, int max) {
        final int number = Integer.parseInt(matcher.group(1));
        if (number < min || number > max) {
            throw new IllegalArgumentException("the number must be >= " + min + " and <=" + max);
        }
        return new int[]{number};
    }
}
