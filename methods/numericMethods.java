package methods;

public class numericMethods {
    // Вычисляет является ли переданный символ числом
    public static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
