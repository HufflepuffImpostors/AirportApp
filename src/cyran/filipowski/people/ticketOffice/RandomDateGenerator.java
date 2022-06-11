package cyran.filipowski.people.ticketOffice;

import java.time.LocalDateTime;
import java.util.Random;

public class RandomDateGenerator {
    public static LocalDateTime generateRandomDate (LocalDateTime start, LocalDateTime end) {
        Random random = new Random();
        int day = end.getDayOfYear() - start.getDayOfYear();
        if (day == 0) day = 2;
        day = random.nextInt()%day;
        int hour = Math.abs(random.nextInt()%24);
        int minute = Math.abs(random.nextInt()%60);

        LocalDateTime generatedDate = start.plusDays(day);
        generatedDate = generatedDate.withHour(hour);
        generatedDate = generatedDate.withMinute(minute);

        return generatedDate;
    }
}
