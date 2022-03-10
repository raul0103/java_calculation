package utils;

import java.util.Stack;

import methods.romanMethods;
import methods.numericMethods;
import methods.operatorMethods;

public class control {
    public static Stack<String> errors = new Stack<>();
    private static Stack<String> $expression;
    private static int $COUNT_OPERATOR;
    private static int $MAX_NUM;
    private static int $MIN_NUM;

    public static void main(Stack<String> expression, int COUNT_OPERATOR, int MAX_NUM, int MIN_NUM) {
        $expression = expression;
        $COUNT_OPERATOR = COUNT_OPERATOR;
        $MAX_NUM = MAX_NUM;
        $MIN_NUM = MIN_NUM;

        checkMinMaxNum();
        checkOperatorAndFloat();

        // Если есть хоть одна ошибка возвращаем массив ошибок
        if (errors.size() > 0)
            throw new NullPointerException(errors.toString());

    }

    static void checkMinMaxNum() {
        boolean numeric = false;
        boolean roman = false;

        Stack<String> error_values = new Stack<String>();

        for (int i = 0; i < $expression.size(); i++) {
            String value = $expression.get(i);

            if (numericMethods.isNumeric(value)) {
                numeric = true;
                int numeric_num = Integer.parseInt(value);
                if (numeric_num > $MAX_NUM)
                    errors.push("Число превышает максимальное значение " + $MAX_NUM + " (" + value + ")");
                if (numeric_num < $MIN_NUM)
                    errors.push("Число меньше минимального значения " + $MIN_NUM + " (" + value + ")");
            } else if (romanMethods.isRoman(value)) {
                roman = true;
                int roman_num = romanMethods.getValue(value);
                if (roman_num > $MAX_NUM)
                    errors.push("Римское число превышает максимальное значение " + $MAX_NUM + " (" + value + ")");
                if (roman_num < $MIN_NUM)
                    errors.push("Римское число меньше минимального значения " + $MIN_NUM + " (" + value + ")");
            } else if (!operatorMethods.isOperator(value)) {
                // Если это неизвестные символы собираем их в массив для исключения
                error_values.push(value);
            }

        }
        if ($expression.size() == 1)
            errors.push("Cтрока не является математической операцией");
        if (numeric && roman)
            errors.push("Одновременно разные системы счисления");
        if (!numeric && !roman || error_values.size() > 0)
            errors.push("Не известные символы" + " (" + error_values.toString() + ")");
    }

    static void checkOperatorAndFloat() {
        int count = 0;

        String[] operator_array = { "+", "-", "*", "/" };
        String[] float_array = { ".", "," };

        for (int i = 0; i < $expression.size(); i++) {
            String value = $expression.get(i);
            for (String operator : operator_array) {
                if (value.contains(operator))
                    count++;
            }
            for (String float_char : float_array) {
                if (value.contains(float_char)) {
                    errors.push("Число не может быть десятичным " + value);
                }
            }
        }

        if (count > $COUNT_OPERATOR)
            errors.push("формат математической операции не удовлетворяет заданию - два операнда и один оператор  ");
    }
}
