package cyran.filipowski.people.ticketOffice;

import java.time.LocalDateTime;
import java.util.Random;

public class RandomDateGenerator {
    public static LocalDateTime generateRandomDate (LocalDateTime start, LocalDateTime end) {
        Random random = new Random();
        int day = end.getDayOfYear() - start.getDayOfYear();
        day = random.nextInt()%day;
        int hour = random.nextInt()%24;
        int minute = random.nextInt()%60;

        LocalDateTime generatedDate = start.plusDays(day);
        generatedDate = generatedDate.withHour(hour);
        generatedDate = generatedDate.withMinute(minute);

        return generatedDate;
    }
}
