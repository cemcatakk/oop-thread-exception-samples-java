import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static CustomDate getDate(){
        CustomDate date;
        LocalDateTime now = LocalDateTime.now();
        date = new CustomDate(now.getDayOfMonth(),now.getMonthValue(),now.getYear());
        return date;
    }
}
