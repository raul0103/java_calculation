package methods;

import java.util.HashMap;

import data.roman;
import utils.utils;

public class romanMethods {
    private static HashMap<String, String> roman_num = roman.getNR();
    private static HashMap<String, Integer> num_roman = roman.getRN();

    public static boolean isRoman(String value) {
        if (num_roman.containsKey(value))
            return true;
        else
            return false;

    }

    public static int getValue(String value) {
        return num_roman.get(value);
    }


    static void checkNegativeResult(int result) {
        if (result < 0)
            throw new NullPointerException("Результат не может быть отрицательным");
    }

    // Переводим результат в римский
    public static StringBuilder getResult(int result) {

        // Проверяем является ли результат отрицательным
        checkNegativeResult(result);

        String result_string = Integer.toString(result);
        int result_length = result_string.length();
        int spare_length = result_length;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < result_length; i++) {
            char b = result_string.charAt(i);
            StringBuilder key = new StringBuilder();
            key.append(b);
            key.append(utils.genZeros(--spare_length));

            if (roman_num.get(key.toString()) != null)
                output.append(roman_num.get(key.toString()));

        }
        return output;
    }
}
