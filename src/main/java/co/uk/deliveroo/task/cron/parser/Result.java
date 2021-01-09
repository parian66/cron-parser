package co.uk.deliveroo.task.cron.parser;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Result {
    private final int[] minutes;
    private final int[] hours;
    private final int[] dayOfMonths;
    private final int[] months;
    private final int[] dayOfWeeks;
    private final String command;

    public Result(int[] minutes, int[] hours, int[] dayOfMonths, int[] months, int[] dayOfWeeks, String command) {
        this.minutes = minutes;
        this.hours = hours;
        this.dayOfMonths = dayOfMonths;
        this.months = months;
        this.dayOfWeeks = dayOfWeeks;
        this.command = command;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Arrays.equals(minutes, result.minutes) &&
                Arrays.equals(hours, result.hours) &&
                Arrays.equals(dayOfMonths, result.dayOfMonths) &&
                Arrays.equals(months, result.months) &&
                Arrays.equals(dayOfWeeks, result.dayOfWeeks) &&
                Objects.equals(command, result.command);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(command);
        result = 31 * result + Arrays.hashCode(minutes);
        result = 31 * result + Arrays.hashCode(hours);
        result = 31 * result + Arrays.hashCode(dayOfMonths);
        result = 31 * result + Arrays.hashCode(months);
        result = 31 * result + Arrays.hashCode(dayOfWeeks);
        return result;
    }

    public String print() {
        return printItem("minute", minutes) + "\n" +
                printItem("hour", hours) + "\n" +
                printItem("day of month", dayOfMonths) + "\n" +
                printItem("month", months) + "\n" +
                printItem("day of week", dayOfWeeks) + "\n" +
                printItem("command", command);
    }

    private String printItem(String key, String value) {
        return String.format("%-14s%s", key, value);
    }

    private String printItem(String name, int[] numbers) {
        final String collect = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        return printItem(name, collect);
    }
}
