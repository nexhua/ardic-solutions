package com.ardic.one;

import java.util.Map;
import java.util.regex.Pattern;

public class NumberString {

    public static final Map<Character, String> numberMappings = Map.of('0', "sıfır", '1', "bir", '2', "iki", '3', "üç", '4', "dört", '5', "beş", '6', "altı", '7', "yedi", '8', "sekiz", '9', "dokuz");

    private final String number;

    private boolean isNegative = false;

    private boolean isFloating = false;

    private String integralPart = "";
    private String fractionalPart = "";

    public NumberString(String number) {
        this.number = number;
    }

    private boolean parse() {
        if (this.number.length() == 0) {
            System.out.println("Number can't be empty.");
            return false;
        }

        String parsed = this.number;

        if (parsed.charAt(0) == '-') {
            this.isNegative = true;
            parsed = parsed.substring(1);
        }

        int index = parsed.indexOf(",");

        if (index != -1) {
            this.isFloating = true;

            String integralStr = parsed.substring(0, index);
            String fractionalStr = parsed.substring(index + 1);

            Pattern digitsPattern = Pattern.compile("[0-9]+");

            if (digitsPattern.matcher(integralStr).matches()) {
                this.integralPart = integralStr;
            } else {
                return false;
            }

            if (digitsPattern.matcher(fractionalStr).matches()) {
                this.fractionalPart = fractionalStr;
            } else {
                return false;
            }
        } else {
            Pattern digitsPattern = Pattern.compile("[0-9]+");

            if (digitsPattern.matcher(parsed).matches()) {
                this.integralPart = parsed;
            } else {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        boolean isParsed = this.parse();

        if (isParsed) {
            StringBuilder builder = new StringBuilder();

            if (this.isNegative) {
                builder.append("-");
            }

            for(int i =0;i<this.integralPart.length();i++) {
                String val = numberMappings.get(this.integralPart.charAt(i));
                builder.append(val != null ? val : "");
            }

            if(this.isFloating) {
                builder.append(",");

                for(int i =0;i<this.fractionalPart.length();i++) {
                    String val = numberMappings.get(this.fractionalPart.charAt(i));
                    builder.append(val != null ? val : "");
                }
            }

            return builder.toString();
        } else {
            System.out.println("Invalid string pattern.");
            return "";
        }

    }
}


