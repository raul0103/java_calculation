import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

import classes.Calculation;
import utils.control;
import utils.utils;

public class Main {
	public static void main(String[] args) {
		int COUNT_OPERATOR = 1;// Разрешенное количество опереаторов
		int MAX_NUM = 10;// Максимальное число
		int MIN_NUM = 1;// Минимальное число

		Scanner scan = new Scanner(System.in, "utf-8");
		PrintStream ps = new PrintStream(System.out);

		ps.print("Выражение:\t");

		// Получаем выражение
		String expression = scan.nextLine();
		scan.close();

		// Разделяем числа от операторов
		Stack<String> expression_array = utils.concatenateDigits(expression.replaceAll(" ", "").split(""));

		// Проверяем выражение
		control.main(expression_array, COUNT_OPERATOR, MAX_NUM, MIN_NUM);

		// Вызываем основную функцию расчета
		String result = Calculation.main(expression_array);

		ps.println("Ответ:\t" + result);

	}

}
