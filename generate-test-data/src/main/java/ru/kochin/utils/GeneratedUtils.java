package ru.kochin.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

public final class GeneratedUtils {

    private static final int MAX_GENERATED_SUM = 100000;
    private static final int MIN_GENERATED_SUM = 10000;

    /**
     * Don't let anyone instantiate this class.
     */
    private GeneratedUtils() {
    }

    public static BigDecimal generateRandomSum() {

        double randValue = Math.random() * (MAX_GENERATED_SUM - MIN_GENERATED_SUM + 1) + MIN_GENERATED_SUM;

        double scale = Math.pow(10, 2);

        return BigDecimal.valueOf(Math.round(randValue * scale) / scale);
    }

    public static LocalDateTime generateLocalDateTime() {
        LocalDateTime now = LocalDateTime.now();

        int month = generateRandomInt(12, 1);
        int dayOfMonth = generateDayOfMonth(month);

        return LocalDateTime.of(now.getYear() - 1,
                month,
                dayOfMonth,
                generateRandomInt(23, 0),
                generateRandomInt(59, 0),
                generateRandomInt(59, 0)
        );
    }

    public static int generateRandomInt(int max, int min) {

        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private static int generateDayOfMonth(int month) {

        int dayOfMonth = generateRandomInt(31, 1);

        return dayOfMonth > Month.of(month).minLength() ? Month.of(month).minLength() : dayOfMonth;
    }
}
