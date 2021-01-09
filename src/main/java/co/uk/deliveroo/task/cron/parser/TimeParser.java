package co.uk.deliveroo.task.cron.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class TimeParser {
    protected final Pattern pattern;

    protected TimeParser(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    final int[] extract(String expression, int min, int max) {
        final Matcher matcher = pattern.matcher(expression);

        if (!matcher.find()) {
            throw new IllegalArgumentException("expression is invalid");
        }


        return extract(matcher, min, max);
    }

    abstract int[] extract(Matcher matcher, int min, int max);
}
