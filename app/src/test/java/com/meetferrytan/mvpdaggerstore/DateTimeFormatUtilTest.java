package com.meetferrytan.mvpdaggerstore;

import com.meetferrytan.mvpdaggerstore.util.format.DateTimeFormatUtil;

import org.junit.Test;

import java.util.Calendar;
import static org.junit.Assert.*;
/**
 * Created by ferrytan on 27/12/17.
 */

public class DateTimeFormatUtilTest {
    @Test
    public void yearsAgo_isCorrect(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_YEAR), "1 year ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MONTH), "1 year ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_WEEK), "1 year ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_DAY), "1 year ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_HOUR), "1 year ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MINUTES), "1 year ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_SECONDS), "1 year ago");

        calendar.add(Calendar.YEAR, -1);
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_YEAR), "2 years ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MONTH), "2 years ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_WEEK), "2 years ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_DAY), "2 years ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_HOUR), "2 years ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MINUTES), "2 years ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_SECONDS), "2 years ago");
    }

    @Test
    public void monthsAgo_isCorrect(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_YEAR), "1 month ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MONTH), "1 month ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_WEEK), "1 month ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_DAY), "1 month ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_HOUR), "1 month ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MINUTES), "1 month ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_SECONDS), "1 month ago");

        calendar.add(Calendar.MONTH, -1);
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_YEAR), "2 months ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MONTH), "2 months ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_WEEK), "2 months ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_DAY), "2 months ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_HOUR), "2 months ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MINUTES), "2 months ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_SECONDS), "2 months ago");
    }

    @Test
    public void weeksAgo_isCorrect(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_YEAR), "1 week ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MONTH), "1 week ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_WEEK), "1 week ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_DAY), "1 week ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_HOUR), "1 week ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MINUTES), "1 week ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_SECONDS), "1 week ago");

        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_YEAR), "2 weeks ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MONTH), "2 weeks ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_WEEK), "2 weeks ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_DAY), "2 weeks ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_HOUR), "2 weeks ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MINUTES), "2 weeks ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_SECONDS), "2 weeks ago");
    }

    @Test
    public void yesterdayDate_isCorrect(){
        Calendar yesterdayCalendar = Calendar.getInstance();
        yesterdayCalendar.add(Calendar.DAY_OF_YEAR, -1);

        assertEquals(DateTimeFormatUtil.millisToReadableDate(yesterdayCalendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_YEAR), "Yesterday");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(yesterdayCalendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MONTH), "Yesterday");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(yesterdayCalendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_WEEK), "Yesterday");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(yesterdayCalendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_DAY), "Yesterday");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(yesterdayCalendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_HOUR), "Yesterday");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(yesterdayCalendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MINUTES), "Yesterday");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(yesterdayCalendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_SECONDS), "Yesterday");
    }

    @Test
    public void daysAgo_isCorrect(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -2);
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_YEAR), "2 days ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MONTH), "2 days ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_WEEK), "2 days ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_DAY), "2 days ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_HOUR), "2 days ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MINUTES), "2 days ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_SECONDS), "2 days ago");

        calendar.add(Calendar.DAY_OF_YEAR, -1);
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_YEAR), "3 days ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MONTH), "3 days ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_WEEK), "3 days ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_DAY), "3 days ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_HOUR), "3 days ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MINUTES), "3 days ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_SECONDS), "3 days ago");
    }

    @Test
    public void hoursAgo_isCorrect(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, -1);
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_YEAR), "1 hour ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MONTH), "1 hour ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_WEEK), "1 hour ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_DAY), "1 hour ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_HOUR), "1 hour ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MINUTES), "1 hour ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_SECONDS), "1 hour ago");

        calendar.add(Calendar.HOUR_OF_DAY, -1);
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_YEAR), "2 hours ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MONTH), "2 hours ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_WEEK), "2 hours ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_DAY), "2 hours ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_HOUR), "2 hours ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MINUTES), "2 hours ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_SECONDS), "2 hours ago");
    }

    @Test
    public void minutesAgo_isCorrect(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -1);
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_YEAR), "1 minute ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MONTH), "1 minute ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_WEEK), "1 minute ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_DAY), "1 minute ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_HOUR), "1 minute ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MINUTES), "1 minute ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_SECONDS), "1 minute ago");

        calendar.add(Calendar.MINUTE, -1);
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_YEAR), "2 minutes ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MONTH), "2 minutes ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_WEEK), "2 minutes ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_DAY), "2 minutes ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_HOUR), "2 minutes ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MINUTES), "2 minutes ago");
        assertNotEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_SECONDS), "2 minutes ago");
    }

    @Test
    public void secondsAgo_isCorrect(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, -1);
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_YEAR), "1 second ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MONTH), "1 second ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_WEEK), "1 second ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_DAY), "1 second ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_HOUR), "1 second ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MINUTES), "1 second ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_SECONDS), "1 second ago");

        calendar.add(Calendar.SECOND, -1);
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_YEAR), "2 seconds ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MONTH), "2 seconds ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_WEEK), "2 seconds ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_DAY), "2 seconds ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_HOUR), "2 seconds ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_MINUTES), "2 seconds ago");
        assertEquals(DateTimeFormatUtil.millisToReadableDate(calendar.getTimeInMillis(), DateTimeFormatUtil.BOUND_SECONDS), "2 seconds ago");
    }
}
