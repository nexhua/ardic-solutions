package com.ardic.one;

import java.util.Map;

public class Mappings {
    public static final Map<Character, String> digits = Map.of('0', "sıfır", '1', "bir", '2', "iki", '3', "üç", '4', "dört", '5', "beş", '6', "altı", '7', "yedi", '8', "sekiz", '9', "dokuz");

    public static final Map<Character, String> tensDigits = Map.of('0', "sıfır", '1', "on", '2', "yirmi", '3', "otuz", '4', "kırk", '5', "elli", '6', "altmış", '7', "yetmiş", '8', "seksen", '9', "doksan");

    public static final Map<Integer, String> powerSuffixes = Map.of(4, "bin", 7, "milyon", 10, "milyar", 13, "trilyon", 16, "katrilyon", 19, "kentilyon", 22, "seksilyon", 25, "septilyon", 28, "oktilyon");

    public static String getNumber(Character character, int power) {
        if (power > 2) {
            return powerSuffixes.get(power);
        }


        return switch (power) {
            case 1 -> digits.get(character);
            case 2 -> tensDigits.get(character);
            default -> "";
        };
    }


    public static String convertHundreds(String number) {
        StringBuilder sb = new StringBuilder();
        int power = 1;

        for (int i = number.length() - 1; i >= 0; i--) {
            Character digit = number.charAt(i);

            if (digit == '0') {
                power++;
                continue;
            }

            if (power == 3) {
                sb.insert(0, digit.compareTo('1') == 0 ? "yüz" : getNumber(digit, 1) + "yüz");
            } else {
                sb.insert(0, getNumber(digit, power));
            }

            power++;
        }

        return sb.toString();
    }

    public static String convertNumber(String number, int startingPower) {
        int power = startingPower;

        StringBuilder sb = new StringBuilder();

        if (power < 4) {
            return convertHundreds(number);
        } else {
            sb.append(convertHundreds(number));

            String suffix = getNumber('0', startingPower);
            if (suffix != null) {
                sb.append(getNumber(number.charAt(0), startingPower));
            }
        }

        return sb.toString();
    }
}
