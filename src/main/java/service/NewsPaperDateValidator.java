package service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class NewsPaperDateValidator {

    public static Date validateAndConvertDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            // Parse and convert string to localDate
            LocalDate localDate = LocalDate.parse(dateStr, formatter);

            // Parse LocalDate to java.sql.Date
            return Date.valueOf(localDate);

        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("the format is wrong, try again");
        }
    }
}

