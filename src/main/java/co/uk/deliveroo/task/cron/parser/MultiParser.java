package co.uk.deliveroo.task.cron.parser;

import java.util.Arrays;
import java.util.regex.Matcher;

class MultiParser extends TimeParser {
    public static final String MULTI_REGEX = "(\\d{1,2})(\\,\\d{1,2})+";

    protected MultiParser() {
        super(MULTI_REGEX);
    }

    @Override
    public int[] extract(Matcher matcher, int min, int max) {
        final int[] numbers = Arrays.stream(matcher.group(0).split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int number : numbers) {
            if (number < min || number > max) {
                throw new IllegalArgumentException("all of the numbers must be >= " + min + " and <=" + max);
            }
        }
        return numbers;
    }
}
