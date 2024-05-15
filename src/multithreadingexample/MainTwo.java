package multithreadingexample;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Random;

public class MainTwo {
    public static String birthDate(int userId) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Get a random year between 1900 and current year
        int year = getRandomNumber(1900, currentDate.getYear());

        // Get a random month (1-12)
        int month = getRandomNumber(1, 12);

        // Get a random day (1-28/29/30/31 depending on month)
        int day = getRandomNumber(1, currentDate.withMonth(month).lengthOfMonth());

        // Construct the random date
        LocalDate randomDate = LocalDate.of(year, month, day);

        // Convert to java.util.Date
        java.util.Date utilDate = (java.util.Date) Date.valueOf(randomDate);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(utilDate);
    }

    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
