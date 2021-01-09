package co.uk.deliveroo.task.cron;

import co.uk.deliveroo.task.cron.parser.Parser;
import co.uk.deliveroo.task.cron.parser.Result;

public class Main {
    private final static String SAMPLE = "You need to enter an argument like: \"*/15 0 1,15 * 1-5 /usr/bin/find\"";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("There is no argument.");
            System.out.println(SAMPLE);
            return;
        }

        if (args.length != 1) {
            System.out.println("There should be only one.");
            System.out.println(SAMPLE);
            return;
        }

        final Parser parser = new Parser();
        try {
            final Result result = parser.pars(args[0]);
            System.out.println(result.print());
        } catch (IllegalArgumentException e) {
            System.out.println("The argument is not valid.");
            System.out.println(SAMPLE);
        }
    }
}
