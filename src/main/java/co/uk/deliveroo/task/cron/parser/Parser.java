package co.uk.deliveroo.task.cron.parser;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static co.uk.deliveroo.task.cron.parser.IntervalParser.INTERVAL_REGEX;
import static co.uk.deliveroo.task.cron.parser.MultiParser.MULTI_REGEX;
import static co.uk.deliveroo.task.cron.parser.SingeParser.SINGLE_REGEX;
import static co.uk.deliveroo.task.cron.parser.StarParser.ALL_REGEX;

public class Parser {
    private static final String TIME_REGEX = RangeParser.RANGE_REGEX + "|"
            + MULTI_REGEX + "|"
            + INTERVAL_REGEX + "|"
            + SINGLE_REGEX + "|"
            + ALL_REGEX;

    private static final String EXPRESSION_REGEX = "(?<minute>" + TIME_REGEX + ") " +
            "(?<hour>" + TIME_REGEX + ") " +
            "(?<dayOfMonth>" + TIME_REGEX + ") " +
            "(?<month>" + TIME_REGEX + ") " +
            "(?<dayOfWeek>" + TIME_REGEX + ") " +
            "(?<command>.*)";

    private static final Pattern EXPRESSION_PATTERN = Pattern.compile(EXPRESSION_REGEX);
    private static final TimeParser[] TIME_PATTERNS = {new RangeParser(), new MultiParser(), new IntervalParser(), new SingeParser(), new StarParser()};

    public Result pars(String expresion) {
        if (expresion == null) {
            throw new IllegalArgumentException("expression is invalid");
        }

        final Matcher matcher = EXPRESSION_PATTERN.matcher(expresion);
        if (!matcher.find()) {
            throw new IllegalArgumentException("expression is invalid");
        }

        return new Result(extract(matcher.group("minute"), 0, 59),
                extract(matcher.group("hour"), 0, 23),
                extract(matcher.group("dayOfMonth"), 1, 31),
                extract(matcher.group("month"), 1, 12),
                extract(matcher.group("dayOfWeek"), 1, 7),
                matcher.group("command"));
    }

    private int[] extract(String expression, int min, int max) {
        for (TimeParser timeParser : TIME_PATTERNS) {
            try {
                return timeParser.extract(expression, min, max);
            } catch (IllegalArgumentException ignored) {
            }
        }
        throw new IllegalArgumentException("expression is not valid");
    }
}
