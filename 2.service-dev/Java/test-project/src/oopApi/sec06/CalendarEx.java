package oopApi.sec06;

import java.time.LocalDateTime;
import java.util.Calendar;

public class CalendarEx {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        // day of a week
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        System.out.printf("Today is %s.%n", days[dayOfWeek - 1]);
        // Or
        String dayOfWeekStr = switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY -> "Sunday";
            case Calendar.MONDAY -> "Monday";
            case Calendar.TUESDAY -> "Tuesday";
            case Calendar.WEDNESDAY -> "Wednesday";
            case Calendar.THURSDAY -> "Thursday";
            case Calendar.FRIDAY -> "Friday";
            case Calendar.SATURDAY -> "Saturday";
            default -> "Unknown";
        };
        System.out.println("Today is " + dayOfWeekStr);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int amPm = calendar.get(Calendar.AM_PM);
        int hour = calendar.get(Calendar.HOUR);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour format
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        System.out.printf("Current date: %d-%02d-%02d%n", year, month, day);
        System.out.printf("Current time: %02d:%02d:%02d%n", hourOfDay, minute, second);
        System.out.printf("Current time (12-hour format): %02d:%02d:%02d %s%n", hour, minute, second, amPm == Calendar.AM ? "AM" : "PM");

        // Local date and time
        LocalDateTime n = LocalDateTime.now();
        System.out.printf("Local date and time: %d-%02d-%02d", n.getYear(), n.getMonthValue(), n.getDayOfMonth());
        System.out.println("Tomorrow's date: " + n.plusDays(1).getMonthValue() + "-" + n.plusDays(1).getDayOfMonth());


    }
}
