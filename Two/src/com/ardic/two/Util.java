package com.ardic.two;

import java.util.HashMap;
import java.util.Map;

public class Util {

    private static final Map<Integer, Boolean> LEAP_YEAR_MAP = new HashMap<>();

    private static final Map<Integer, Long> YEAR_MINUTES_MAP = new HashMap<>();

    public static int getMonthLength(Month month, int year) {
        switch (month) {

            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> {
                return 31;
            }
            case FEBRUARY -> {
                return isLeapYear(year) ? 29 : 28;
            }
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> {
                return 30;
            }
            default -> {
                return 0;
            }
        }

    }


    public static boolean isLeapYear(int year) {
        Boolean isLeapYear = LEAP_YEAR_MAP.get(year);

        if (isLeapYear == null) {


            boolean isLeap = year % 4 == 0;

            isLeap = isLeap && (year % 100 != 0 || year % 400 == 0);

            LEAP_YEAR_MAP.put(year, isLeap);
            return isLeap;
        }

        return isLeapYear;
    }

    public static long yearToMinutes(int year) {
        Long yearMinutes = YEAR_MINUTES_MAP.get(year);

        if(yearMinutes == null) {
            int yearLength = isLeapYear(year) ? 366 : 365;
            yearMinutes = yearLength * 24L * 60L;
            YEAR_MINUTES_MAP.put(year, yearMinutes);
        }

        return yearMinutes;
    }

    public static long monthsToMinutes(int month, int year) {

        int days = 0;

        for(int i=1;i<month;i++) {
            Month monthEnum = Month.fromInt(i);
            days += getMonthLength(monthEnum, year);
        }

        return days * 24L * 60L;

    }

    public static long daysToMinutes(int day) {
        // Assume day is at 12:00 noon
        return (day - 1) * 24L * 60L + 12L;
    }


    public static WeekDays calculateWeekDay(WeekDays from, int add) {
        int daysToAdd = add % 7;

        return WeekDays.fromInt(daysToAdd);
    }


}