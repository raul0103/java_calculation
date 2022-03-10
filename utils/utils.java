package utils;

import java.util.Stack;

import methods.numericMethods;
import methods.romanMethods;
import methods.operatorMethods;

public class utils {

    // Разделяет числа от операторов
    public static Stack<String> concatenateDigits(String... values) {
        Stack<String> arr = new Stack<>();
        StringBuilder sb = new StringBuilder(values.length);

        for (String value : values) {
            // проверяем является ли value числом, римским числом, либо оператором
            if (numericMethods.isNumeric(value) || romanMethods.isRoman(value)) {
                sb.append(value); // Если символ является числом - конкатенируем его в sb (если числа многозначные). Так же подходит для римских чисел
            } else if (operatorMethods.isOperator(value)){
                arr.push(sb.toString()); // Если это оператор - добавляем в массив сконкатенированное число из sb
                arr.push(value); // Так же добавляем сам символ (оператор)
                sb.delete(0, sb.length()); // Очищаем sb для конкатенации следующего числа
            } else {
                sb.append(value); //Если это не ивестные символы конкатенируем их (для ошибок)
            }
        }

        arr.push(sb.toString());
        return arr;
    }

    public static StringBuilder genZeros(int count) {
        StringBuilder zeros = new StringBuilder();
        for (int i = 0; i < count; i++)
            zeros.append("0");

        return zeros;
    }

}
