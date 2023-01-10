import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test_regex {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now().minusDays(3);
        System.out.println(ChronoUnit.DAYS.between(localDate, LocalDate.now()));


        LocalDateTime localDateTime = LocalDateTime.now().minusHours(2);
        System.out.println(ChronoUnit.HOURS.between(localDateTime, LocalDateTime.now()));

    }
}

