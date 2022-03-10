package data;

import java.util.HashMap;

public class roman {
    // RN-RomansNum
    // NR-NumsRoman

    public static HashMap<String, String> RN = new HashMap<>();
    public static HashMap<String, Integer> NR = new HashMap<>();

    public static HashMap<String, String> getNR() {
        RN.put("1", "I");
        RN.put("2", "II");
        RN.put("3", "III");
        RN.put("4", "IV");
        RN.put("5", "V");
        RN.put("6", "VI");
        RN.put("7", "VII");
        RN.put("8", "VIII");
        RN.put("9", "IX");
        RN.put("10", "X");
        RN.put("20", "XX");
        RN.put("30", "XXX");
        RN.put("40", "XL");
        RN.put("50", "L");
        RN.put("60", "LX");
        RN.put("70", "LXX");
        RN.put("80", "LXXX");
        RN.put("90", "XC");
        RN.put("100", "C");
        RN.put("200", "CC");
        RN.put("300", "CCC");
        RN.put("400", "CD");
        RN.put("500", "D");
        RN.put("600", "DC");
        RN.put("700", "DCC");
        RN.put("800", "DCCC");
        RN.put("900", "CM");
        RN.put("1000", "M");

        return RN;
    }

    public static HashMap<String, Integer> getRN() {
        NR.put("I", 1);
        NR.put("II", 2);
        NR.put("III", 3);
        NR.put("IV", 4);
        NR.put("V", 5);
        NR.put("VI", 6);
        NR.put("VII", 7);
        NR.put("VIII", 8);
        NR.put("IX", 9);
        NR.put("X", 10);
        NR.put("XX", 20);
        NR.put("XXX", 30);
        NR.put("XL", 40);
        NR.put("L", 50);
        NR.put("LX", 60);
        NR.put("LXX", 70);
        NR.put("LXXX", 80);
        NR.put("XC", 90);
        NR.put("C", 100);
        NR.put("CC", 200);
        NR.put("CCC", 300);
        NR.put("CD", 400);
        NR.put("D", 500);
        NR.put("DC", 600);
        NR.put("DCC", 700);
        NR.put("DCCC", 800);
        NR.put("CM", 900);
        NR.put("M", 1000);

        return NR;
    }
}
