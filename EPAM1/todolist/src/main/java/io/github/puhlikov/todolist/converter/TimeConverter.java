package by.epam.belsut.kdv.todolist.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class TimeConverter {
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public Long getLongToday(){
        Date date = new Date();
        long todayLong = date.getTime();
        return getTime(new SimpleDateFormat(DATE_FORMAT).format(new Date(todayLong)));
    }

    public Long convertStringToLongTime(String stringTime) {
        return getTime(stringTime);
    }

    private Long getTime(String date) {
        if (date == null) {
            date = new SimpleDateFormat(TimeConverter.DATE_FORMAT).format(new Date());
        }
        try {
            return new SimpleDateFormat(TimeConverter.DATE_FORMAT).parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
