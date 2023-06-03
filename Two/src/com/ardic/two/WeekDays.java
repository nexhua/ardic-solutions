package com.ardic.two;

public enum WeekDays {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;


    public static WeekDays fromInt(int day) {
        return switch (day) {
            case 0 -> WeekDays.MONDAY;
            case 1 -> WeekDays.TUESDAY;
            case 2 -> WeekDays.WEDNESDAY;
            case 3 -> WeekDays.THURSDAY;
            case 4 -> WeekDays.FRIDAY;
            case 5 -> WeekDays.SATURDAY;
            case 6 -> WeekDays.SUNDAY;
            default -> WeekDays.MONDAY;
        };
    }
}
