package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateUtil {

    private static final String POMODORO_DATE_FORMAT = "yyyy-MM-dd HH:mm:ssX";
    
    public static long getDateDiffFromToday(Date date) {
        long diffInMillies = Calendar.getInstance().getTimeInMillis() - date.getTime();
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.DAYS) / (1000 * 60 * 60 * 24);
    }

    public static String getCurrentDateWithTimezone() {
        TimeZone timeZone = TimeZone.getTimeZone("UTC+7");
        Calendar cal = Calendar.getInstance(timeZone);
        SimpleDateFormat format = new SimpleDateFormat(POMODORO_DATE_FORMAT);
        return format.format(cal.getTime());
    }

    public static Date convertToDate(String stringDate) {
        try {
            DateFormat format = new SimpleDateFormat(POMODORO_DATE_FORMAT, Locale.ENGLISH);
            return format.parse(stringDate);
        } catch (Exception e) {
            return Calendar.getInstance().getTime();
        }
    }

    public static int getPomodoroDateOfWeekOrder() {
        Calendar cal = Calendar.getInstance();
        int currentOrder = cal.get(Calendar.DAY_OF_WEEK);
        return calculateDateOfWeekOrder(currentOrder);
    }

    public static int getPomodoroDateOfWeekOrder(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currentOrder = cal.get(Calendar.DAY_OF_WEEK);
        return calculateDateOfWeekOrder(currentOrder);
    }

    private static int calculateDateOfWeekOrder(int currentOrder) {
        int res = currentOrder + 5;
        if (res > 7) {
            res %= 7;
        }
        return res - 1;
    }
}
