package methods;

public class operatorMethods {

    public static boolean isOperator(String value) {
        String[] operator_array = { "+", "-", "*", "/" };
        boolean bool = false;

        for (String operator : operator_array) {
            if (!bool)
                if (operator.contains(value))
                    bool = true;
                else
                    bool = false;
        }

        return bool;

    }
}
