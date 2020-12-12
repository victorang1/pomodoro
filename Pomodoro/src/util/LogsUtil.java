package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import state.Config;

public class LogsUtil {

    private static LogsUtil instance;
    private Map<Integer, Integer> logs;

    private LogsUtil() {
        logs = new HashMap<>();
    }

    public static LogsUtil getInstance() {
        if (instance == null) {
            instance = new LogsUtil();
        }
        return instance;
    }

    public void export(String detail) {
        try {
            FileWriter csvWriter = new FileWriter(Config.LOG_PATH, true);
            csvWriter.append(DateUtil.getCurrentDateWithTimezone());
            csvWriter.append(",");
            csvWriter.append(detail);
            csvWriter.append("\n");

            csvWriter.flush();
            csvWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readLog() {
        try {
            String row;
            BufferedReader csvReader = new BufferedReader(new FileReader(Config.LOG_PATH));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                Date date = DateUtil.convertToDate(data[0]);
                if (DateUtil.getDateDiffFromToday(date) <= 7) {
                    int key = DateUtil.getPomodoroDateOfWeekOrder(date);
                    if (logs.containsKey(key)) {
                        logs.put(key, logs.get(key) + 1);
                    }
                    else {
                        logs.put(key, 1);
                    }
                }
            }
            csvReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getLogsValueFromKey(int key) {
        return this.logs.getOrDefault(key, 0);
    }
}
