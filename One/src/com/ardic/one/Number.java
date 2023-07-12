package com.ardic.one;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Number {

    private final BigDecimal number;

    private boolean isNegative = false;

    private boolean isFloating = false;

    private double integralPart = 0;
    private double fractionalPart = 0;

    public Number(BigDecimal number) {
        this.number = number;
        this.parse();
    }

    private void parse() {
        if (this.number.compareTo(BigDecimal.ZERO) < 0) {
            this.isNegative = true;
        }

        BigDecimal fractional = this.number.remainder(BigDecimal.ONE);

        if (fractional.compareTo(BigDecimal.ZERO) > 0) {
            this.isFloating = true;

            DecimalFormat f = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
            f.setMaximumFractionDigits(340);

            String numberString = f.format(this.number);

            int delimeterIndex = numberString.indexOf('.');
            String integralString = numberString.substring(0, delimeterIndex);
            String fractionalString = numberString.substring(delimeterIndex + 1);

            this.fractionalPart = Double.parseDouble(fractionalString);
            this.integralPart = Double.parseDouble(integralString);
        } else {
            this.integralPart = this.number.doubleValue();
        }


    }


    private String convertNumber(double number) {
        DecimalFormat f = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        f.setMaximumFractionDigits(340);

        StringBuilder sb = new StringBuilder();

        String numberString = f.format(number);

        int numberLength = numberString.length();
        int numberGroupsLength = (int) Math.ceil(numberLength / 3.0);

        int groupEnd = numberLength;
        int groupStart = Math.max(groupEnd - 3, 0);

        int power = 1;


        for (int i = numberGroupsLength - 1; i >= 0; i--) {
            String group = numberString.substring(groupStart, groupEnd);

            sb.insert(0, Mappings.convertNumber(group, power));

            groupEnd = groupStart;
            groupStart = Math.max(groupEnd - 3, 0);
            power += 3;
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (this.isNegative) {
            sb.append("eksi");
            sb.append(convertNumber(this.integralPart * -1.0));
        } else {
            sb.append(convertNumber(this.integralPart));
        }

        if (this.isFloating) {
            sb.append(",");
            sb.append(convertNumber(this.fractionalPart));
        }

        return sb.toString();
    }
}


