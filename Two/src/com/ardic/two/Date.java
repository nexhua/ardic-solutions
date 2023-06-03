package com.ardic.two;

import static com.ardic.two.Util.*;

public class Date {

    // Default values for date, 01.01.1900 accepted as epoch
    private int year;

    private int month;

    private int monthDay;

    private WeekDays weekDay;

    public Date() {
        this.year = 1900;
        this.month = 1;
        this.monthDay = 1;
        this.weekDay = WeekDays.MONDAY;
    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.monthDay = day;

        Date epoch = new Date();
        long minutes = this.toMinutes();

        long dayInMinutes = 24L * 60L;

        int dayDiff = (int) ((minutes - epoch.toMinutes()) / dayInMinutes);

        this.setWeekDay(calculateWeekDay(epoch.getWeekDay(), dayDiff));
    }


    public long toMinutes() {
        Date epoch = new Date();

        long yearMinutes = 0;

        for (int i = epoch.getYear(); i < this.getYear(); i++) {
            yearMinutes += yearToMinutes(i);
        }

        long monthDifference = monthsToMinutes(this.getMonth(), this.getYear()) - monthsToMinutes(epoch.getMonth(), epoch.getYear());

        long dayDifference = daysToMinutes(this.getMonthDay()) - daysToMinutes(epoch.getMonthDay());

        return yearMinutes + monthDifference + dayDifference;
    }


    @Override
    public String toString() {
        return String.format("%02d.%02d.%d", this.getMonthDay(), this.getMonth(), this.getYear());
    }

    //region Getters and Setters

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(int monthDay) {
        this.monthDay = monthDay;
    }

    public WeekDays getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDays weekDay) {
        this.weekDay = weekDay;
    }


    //endregion

}
