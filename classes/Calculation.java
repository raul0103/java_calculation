package classes;

import java.util.Stack;

import methods.numericMethods;
import methods.romanMethods;
import methods.operatorMethods;

public class Calculation {
    static int check = 0;

    // Бежим по массиву элемемнтов выражения и производим расчет
    public static String main(Stack<String> expression_array) {
        int result = 0, num_a = 0;
        String operator = "";
        boolean is_numeric, is_operator, is_roman = false;

        for (String value : expression_array) {
            is_roman = romanMethods.isRoman(value);
            is_numeric = numericMethods.isNumeric(value);
            is_operator = operatorMethods.isOperator(value);

            if (is_numeric || is_roman) {
                int num_b = is_roman ? romanMethods.getValue(value) : Integer.parseInt(value);
                result = calculate(operator, num_a, num_b, result); // Выполняем расчет суммы
                num_a = num_b;
            } else if (is_operator) {
                operator = value;
            } else {

            }

        }
        // Если это операция с римскими числами - переводим результат в римское число
        if (is_roman)
            return romanMethods.getResult(result).toString();
        else
            return Integer.toString(result);
    }

    static int calculate(String operator, int num_a, int num_b, int result) {
        if (operator.indexOf("+") != -1) {
            if (check == 0)
                result = num_a + num_b;
            else
                result += num_b;
            check = 1;
        }

        if (operator.indexOf("-") != -1) {
            if (check == 0)
                result = num_a - num_b;
            else
                result -= num_b;
            check = 1;
        }

        if (operator.indexOf("*") != -1) {
            if (check == 0)
                result = num_a * num_b;
            else
                result *= num_b;
            check = 1;
        }

        if (operator.indexOf("/") != -1) {
            if (check == 0)
                result = num_a / num_b;
            else
                result /= num_b;
            check = 1;
        }

        return result;
    }
}
