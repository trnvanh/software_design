package fi.tuni.prog3.weatherapp.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;


public class DateTimeUtil {
    public static String convertToTimeString(Long epochSeconds) {
        Instant instant = Instant.ofEpochSecond(epochSeconds);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return dateTime.format(formatter);
    }

    public static String getDayOfWeek(long timestamp) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault());
        return dateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
    }

    public static LocalDate convertTimestampToLocalDate(Long epochSeconds) {
        if (epochSeconds == null) {
            throw new IllegalArgumentException("Epoch seconds cannot be null");
        }
        return Instant.ofEpochSecond(epochSeconds) // Convert epoch seconds to Instant
                .atZone(ZoneId.systemDefault())   // Apply system's default time zone
                .toLocalDate();                  // Extract the LocalDate
    }

    public static String convertTimestampToLocalDateTime(Long epochSeconds) {
        Instant instant = Instant.ofEpochSecond(epochSeconds);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = Timestamp.from(instant);
        return timestamp.toLocalDateTime().format(formatter);
    }


    public static String formatLocalDateTime(String inputDateString) {
        LocalDateTime dateTime = LocalDateTime.parse(inputDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return dateTime.format(DateTimeFormatter.ofPattern("E, MMM d"));
    }

    public static String formatDateTime(String inputDateString) {
        LocalDateTime dateTime = LocalDateTime.parse(inputDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return dateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
