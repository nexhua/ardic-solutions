package com.ardic.two;

public enum Month {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);


    public final int month;

    private Month(int month) {
        this.month = month;
    }

    public static Month fromInt(int month) {
        return switch (month) {
            case 1 -> Month.JANUARY;
            case 2 -> Month.FEBRUARY;
            case 3 -> Month.MARCH;
            case 4 -> Month.APRIL;
            case 5 -> Month.MAY;
            case 6 -> Month.JUNE;
            case 7 -> Month.JULY;
            case 8 -> Month.AUGUST;
            case 9 -> Month.SEPTEMBER;
            case 10 -> Month.OCTOBER;
            case 11 -> Month.NOVEMBER;
            case 12 -> Month.DECEMBER;
            default -> Month.JANUARY;
        };
    }
}


