package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateUtil {
    
    public static long getDateDiffFromNow(Date date, TimeUnit timeUnit) {
        long diffInMillies = Calendar.getInstance().getTimeInMillis() - date.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.DAYS) / (1000 * 60 * 60 * 24);
    }

    public static Date convertToDate(String stringDate) {
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssX", Locale.ENGLISH);
            return format.parse(stringDate);
        } catch (Exception e) {
            e.printStackTrace();
            return Calendar.getInstance().getTime();
        }
    }

    public static int getPomodoroDateOfWeekOrder() {
        Calendar cal = Calendar.getInstance();
        int currentDay = cal.get(Calendar.DAY_OF_WEEK);
        return ((currentDay + 5) % 7) - 1;
    }

    public static int getPomodoroDateOfWeekOrder(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currentDay = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println("Current Day = " + currentDay);
        return ((currentDay + 5) % 7);
    }
}
