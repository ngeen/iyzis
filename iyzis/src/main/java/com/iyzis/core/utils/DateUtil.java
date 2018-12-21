package com.iyzis.core.utils;


import com.iyzis.core.domain.enums.Period;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {


    public static Date addMonth(Date date, int month) {
        return DateUtils.addMonths(date, month);
    }

    public static Date getDate() {
        return new Date();
    }

    public static Date getNow() {
        return Calendar.getInstance().getTime();
    }

    public static String getFormattedDateAsString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String formattedDateAsString = dateFormat.format(date);

        return formattedDateAsString;
    }

    public static Date getFormattedDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String formattedDateAsString = dateFormat.format(date);
        Date formattedDate = new Date();

        try {
            formattedDate = org.apache.commons.lang3.time.DateUtils.parseDate(formattedDateAsString, "yyyy-MM-dd hh:mm:ss");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    public static Date getOneMonthBefore() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date oneMonthBefore = cal.getTime();

        return oneMonthBefore;
    }

    public static Date getSubscriptionEndDate(Date date, String period) {

        if (Period.MONTHLY.getPeriod().equalsIgnoreCase(period)) {
            return addMonth(date, 1);
        } else if (Period.ANNUALLY.getPeriod().equalsIgnoreCase(period)) {
            return addMonth(date, 12);
        } else if (Period.WEEKLY.getPeriod().equalsIgnoreCase(period)) {
            return addDays(date, 7);
        } else if (Period.DAILY.getPeriod().equalsIgnoreCase(period)) {
            return addDays(date, 1);
        } else {
            return null;
        }
    }

    public static Date addDays(Date now, int day) {
        return DateUtil.addDays(now, day);
    }
}
