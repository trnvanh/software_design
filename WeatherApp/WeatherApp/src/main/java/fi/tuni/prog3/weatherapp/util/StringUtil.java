package fi.tuni.prog3.weatherapp.util;

public class StringUtil {

    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Return as-is if input is null or empty
        }
        // Capitalize the first letter and append the rest of the string
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
