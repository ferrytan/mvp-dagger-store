package com.meetferrytan.mvpdaggerstore.util.format;

import android.support.annotation.IntDef;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import timber.log.Timber;

/**
 * Created by ferrytan on 11/21/16.
 */

public class DateTimeFormatUtil {
    private static final String DEFAULT_DATE_FORMAT_FULL = "dd MMM yyyy";
    private static final String DEFAULT_DATE_FORMAT_PARTIAL = "dd MMM";
    private static final String DEFAULT_DATE_FORMAT_YESTERDAY = "'Yesterday at' HH:mm";
    private static final String DEFAULT_DATE_FORMAT_TOMORROW = "'Tomorrow at' HH:mm";
    private static final String DEFAULT_DATE_FORMAT_DATETIME = "dd MMM 'at' HH:mm";
    private static final String DEFAULT_DATE_FORMAT_TIME = "HH:mm";
    private static final String YESTERDAY = "Yesterday";
    private static final String DEFAULT_POSTFIX = " ago";
    private static final String DEFAULT_PLURAL = "s";
    private static final String DEFAULT_PREFIX_YEARS = " year";
    private static final String DEFAULT_PREFIX_MONTHS = " month";
    private static final String DEFAULT_PREFIX_WEEKS = " week";
    private static final String DEFAULT_PREFIX_DAYS = " day";
    private static final String DEFAULT_PREFIX_HOURS = " hour";
    private static final String DEFAULT_PREFIX_MINUTES = " minute";
    private static final String DEFAULT_PREFIX_SECONDS = " second";

    private static final String PREFIX_SECONDS_SHORT = "s";
    private static final String PREFIX_MINUTES_SHORT = "m";
    private static final String PREFIX_HOUR_SHORT = "h";

    private static final int IDENTIFIER_TIME_AGO = 91;
    private static final int IDENTIFIER_TIME_AT = 92;
    private static final int IDENTIFIER_TIME_EXACT = 93;

    private static final long ONE_SECOND = 1000;
    private static final long SECONDS = 60;

    private static final long ONE_MINUTE = ONE_SECOND * SECONDS;
    private static final long MINUTES = 60;

    private static final long ONE_HOUR = ONE_MINUTE * MINUTES;
    private static final long HOURS = 24;

    private static final long ONE_DAY = ONE_HOUR * HOURS;
    private static final long DAYS_OF_WEEK = 7;
    private static final long DAYS_OF_MONTH = 30;

    private static final long ONE_WEEK = ONE_DAY * DAYS_OF_WEEK;
    private static final long WEEKS = 4;

    private static final long ONE_MONTH = ONE_DAY * DAYS_OF_MONTH;
    private static final long MONTHS = 12;

    private static final long ONE_YEAR = ONE_MONTH * MONTHS;

    private static final long MAX_YEAR = 9999;

    @IntDef({BOUND_YEAR, BOUND_MONTH, BOUND_WEEK, BOUND_DAY, BOUND_HOUR, BOUND_MINUTES, BOUND_SECONDS})
    private @interface FormatBound {
    }

    public static final int BOUND_YEAR = 1;
    public static final int BOUND_MONTH = 2;
    public static final int BOUND_WEEK = 3;
    public static final int BOUND_DAY = 4;
    public static final int BOUND_HOUR = 5;
    public static final int BOUND_MINUTES = 6;
    public static final int BOUND_SECONDS = 7;

    public DateTimeFormatUtil() {

    }

    public static String millisToDateTimeFormat(long timestampInUtcMilliseconds) {

        Calendar targetCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        targetCalendar.setTimeInMillis(timestampInUtcMilliseconds);
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATE_FORMAT_DATETIME, Locale.getDefault());
        formatter.setTimeZone(TimeZone.getDefault());

        String readableDate = formatter.format(targetCalendar.getTimeInMillis());

        Timber.d("millisToDateTimeFormat: " + readableDate);
        return readableDate;
    }

    public static String millisToFullDate(long timestampInUtcMilliseconds) {
        long now = System.currentTimeMillis();
        Calendar nowCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        nowCalendar.setTimeInMillis(now);

        Calendar targetCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        targetCalendar.setTimeInMillis(timestampInUtcMilliseconds);

        String dateFormat = DEFAULT_DATE_FORMAT_DATETIME;

        boolean sameDay = nowCalendar.get(Calendar.YEAR) == targetCalendar.get(Calendar.YEAR) &&
                nowCalendar.get(Calendar.DAY_OF_YEAR) == targetCalendar.get(Calendar.DAY_OF_YEAR);
        if (sameDay) {
            dateFormat = DEFAULT_DATE_FORMAT_TIME;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.getDefault());
        formatter.setTimeZone(TimeZone.getDefault());

        String readableDate = formatter.format(targetCalendar.getTimeInMillis());

        Timber.d("millisToFullDate: " + readableDate);
        return readableDate;
    }

    /**
     * converts time (in milliseconds) to human-readable format
     *
     * @param timestampInUtcMilliseconds = unix timestamp in seconds
     * @param bounds                     = maximum format to show, if below maximum, show DURATION in format else show TIMESTAMP in full format
     *                                   (eg:
     *                                   today = 10/10/2016 ; timestamp = 10/08/2014 ; duration = 1 Years 2 month
     *                                   BOUND_YEAR -> 2 Years Ago
     *                                   BOUND_MONTH etc -> 10/08/2014
     *                                   <p>
     *                                   today = 10/10/2016 ; timestamp = 10/18/2016 ; duration = 2 months
     *                                   BOUND_YEAR ~ BOUND_MONTH -> 2 months
     *                                   BOUND_WEEK etc --> 10/18/2016
     *                                   <p>
     *                                   today = 10/10/2016 ; timestamp = 07/10/2016 ; duration = 3 days
     *                                   BOUND_YEAR ~ BOUND_DAY -> 3 days ago
     *                                   BOUND_HOURS etc --> 07/10/2014
     */
    public static String millisToReadableDate(long timestampInUtcMilliseconds, @FormatBound int bounds, String fullDateFormat) {
        long now = System.currentTimeMillis();
        long duration = (now - timestampInUtcMilliseconds);
        String readableDate;

        Calendar nowCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        nowCalendar.setTimeInMillis(now);

        Calendar targetCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        targetCalendar.setTimeInMillis(timestampInUtcMilliseconds);

        SimpleDateFormat formatter;
        boolean isLastYear = nowCalendar.get(Calendar.YEAR) - targetCalendar.get(Calendar.YEAR) > 0;
        boolean isYesterday;
        if (isLastYear) {
            Calendar firstMinuteOfdecember31st = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            firstMinuteOfdecember31st.setTimeInMillis(timestampInUtcMilliseconds);
            firstMinuteOfdecember31st.set(Calendar.MONTH, Calendar.DECEMBER);
            firstMinuteOfdecember31st.set(Calendar.DAY_OF_MONTH, 12);
            firstMinuteOfdecember31st.set(Calendar.HOUR_OF_DAY, 0);
            firstMinuteOfdecember31st.set(Calendar.MINUTE, 0);
            firstMinuteOfdecember31st.set(Calendar.SECOND, 1);

            Calendar lastMinuteOfJanuary1st = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            lastMinuteOfJanuary1st.setTimeInMillis(now);
            lastMinuteOfJanuary1st.set(Calendar.MONTH, Calendar.JANUARY);
            lastMinuteOfJanuary1st.set(Calendar.DAY_OF_MONTH, 1);
            lastMinuteOfJanuary1st.set(Calendar.HOUR_OF_DAY, 23);
            lastMinuteOfJanuary1st.set(Calendar.MINUTE, 59);
            lastMinuteOfJanuary1st.set(Calendar.SECOND, 59);

            isYesterday = targetCalendar.after(firstMinuteOfdecember31st) && nowCalendar.before(lastMinuteOfJanuary1st);
        } else {
            isYesterday = nowCalendar.get(Calendar.DAY_OF_YEAR) - targetCalendar.get(Calendar.DAY_OF_YEAR) == 1;
        }

        if (isYesterday) {
            readableDate = YESTERDAY;
        } else {
            DateDetail dateDetail = defineDatePrefix(bounds, new DateDetail(duration));
            long total = dateDetail.getTotal();
            long maxTotal = dateDetail.getMaxTotal();
            if (total <= maxTotal) {
                String prefix = dateDetail.getPrefix();
                readableDate = String.valueOf(total) + prefix;
                if (total > 1) readableDate += DEFAULT_PLURAL;
                readableDate += DEFAULT_POSTFIX;
            } else {
                if (fullDateFormat != null) {
                    formatter = new SimpleDateFormat(fullDateFormat, Locale.getDefault());
                } else {
                    formatter = new SimpleDateFormat(isLastYear ? DEFAULT_DATE_FORMAT_FULL : DEFAULT_DATE_FORMAT_DATETIME, Locale.getDefault());
                }
                formatter.setTimeZone(TimeZone.getDefault());

                readableDate = formatter.format(targetCalendar.getTimeInMillis());
            }
        }
        Timber.d("millisToReadableDate: " + readableDate);
        return readableDate;
    }

    private static DateDetail defineDatePrefix(int lastCheckedBound, DateDetail dateDetail) {

        long duration = dateDetail.getDuration();
        long total;
        long maxTotal;
        String prefix;

        if (lastCheckedBound == BOUND_YEAR) {
            if (duration >= ONE_YEAR) {
                total = duration / ONE_YEAR;
                prefix = DEFAULT_PREFIX_YEARS;
                maxTotal = MAX_YEAR;
            } else {
                return defineDatePrefix(lastCheckedBound+1, dateDetail);
            }
        } else if (lastCheckedBound == BOUND_MONTH) {
            if (duration >= ONE_MONTH) {
                total = duration / ONE_MONTH;
                prefix = DEFAULT_PREFIX_MONTHS;
                maxTotal = DAYS_OF_MONTH;
            } else {
                return defineDatePrefix(lastCheckedBound+1, dateDetail);
            }
        } else if (lastCheckedBound == BOUND_WEEK) {
            if (duration >= ONE_WEEK) {
                total = duration / ONE_WEEK;
                prefix = DEFAULT_PREFIX_WEEKS;
                maxTotal = WEEKS;
            } else {
                return defineDatePrefix(lastCheckedBound+1, dateDetail);
            }
        } else if (lastCheckedBound == BOUND_DAY) {
            if (duration >= ONE_DAY) {
                total = duration / ONE_DAY;
                prefix = DEFAULT_PREFIX_DAYS;
                maxTotal = DAYS_OF_WEEK;
            } else {
                return defineDatePrefix(lastCheckedBound+1, dateDetail);
            }
        } else if (lastCheckedBound == BOUND_HOUR) {
            if (duration >= ONE_HOUR) {
                total = duration / ONE_HOUR;
                prefix = DEFAULT_PREFIX_HOURS;
                maxTotal = HOURS;
            } else {
                return defineDatePrefix(lastCheckedBound+1, dateDetail);
            }
        } else if (lastCheckedBound == BOUND_MINUTES) {
            if (duration >= ONE_MINUTE) {
                total = duration / ONE_MINUTE;
                prefix = DEFAULT_PREFIX_MINUTES;
                maxTotal = MINUTES;
            } else {
                return defineDatePrefix(lastCheckedBound+1, dateDetail);
            }
        } else {
            total = duration / ONE_SECOND;
            prefix = DEFAULT_PREFIX_SECONDS;
            maxTotal = SECONDS;
        }

        dateDetail.setTotal(total);
        dateDetail.setPrefix(prefix);
        dateDetail.setMaxTotal(maxTotal);

        return dateDetail;
    }

    public static String millisToReadableDate(long timestampInUtcMilliseconds, @FormatBound int bounds) {
        return millisToReadableDate(timestampInUtcMilliseconds, bounds, null);
    }

    public static String millisToDateFormat(long timestampInUtcMilliseconds, String dateFormat) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat, Locale.getDefault());
        dateFormatter.setTimeZone(TimeZone.getDefault());
        String readableDate = dateFormatter.format(timestampInUtcMilliseconds);

        Timber.d("millisToDateFormat: " + readableDate);
        return readableDate;
    }

    private static class DateDetail {
        private long total;
        private long duration;
        private long maxTotal;
        private String prefix;

        public DateDetail(long duration) {
            this.duration = duration;
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public long getDuration() {
            return duration;
        }

        public void setDuration(long duration) {
            this.duration = duration;
        }

        public long getMaxTotal() {
            return maxTotal;
        }

        public void setMaxTotal(long maxTotal) {
            this.maxTotal = maxTotal;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }
    }
}