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

    private String integralPart = "0";
    private String fractionalPart = "0";

    public Number(BigDecimal number) {
        this.number = number;
        this.parse();
    }

    private void parse() {
        if (this.number.compareTo(BigDecimal.ZERO) < 0) {
            this.isNegative = true;
        }

        BigDecimal fractional = this.number.remainder(BigDecimal.ONE).abs();

        if (fractional.compareTo(BigDecimal.ZERO) > 0) {
            this.isFloating = true;

            this.fractionalPart = fractional.toString().substring(2);
            this.integralPart = this.number.toBigInteger().toString();
        } else {
            this.integralPart = this.number.toBigInteger().toString();
        }


    }


    private String convertNumber(String number) {
        StringBuilder sb = new StringBuilder();

        int numberLength = number.length();
        int numberGroupsLength = (int) Math.ceil(numberLength / 3.0);

        int groupEnd = numberLength;
        int groupStart = Math.max(groupEnd - 3, 0);

        int power = 1;


        for (int i = numberGroupsLength - 1; i >= 0; i--) {
            String group = number.substring(groupStart, groupEnd);

            sb.insert(0, Mappings.convertNumber(group, power));

            groupEnd = groupStart;
            groupStart = Math.max(groupEnd - 3, 0);
            power += 3;
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        if(this.number.compareTo(BigDecimal.ZERO) == 0) {
            return "sifir";
        }

        StringBuilder sb = new StringBuilder();

        if (this.isNegative) {
            sb.append("eksi");
            sb.append(convertNumber(this.integralPart.substring(1)));
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


