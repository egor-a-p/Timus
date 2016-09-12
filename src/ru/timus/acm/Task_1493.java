package ru.timus.acm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
Вова купил билет в трамвае 13-го маршрута и сразу посчитал суммы первых трёх цифр и последних трёх цифр номера билета (номер у билета шестизначный).
Оказалось, что суммы отличаются ровно на единицу. «Я в одном шаге от счастья», — подумал Вова, — «или предыдущий или следующий билет точно счастливый». Прав ли он?
Исходные данные
В единственной строке записан номер билета. Номер состоит ровно из шести цифр, среди которых могут быть и нули.
Гарантируется, что Вова умеет считать, то есть суммы первых трёх цифр и последних трёх цифр отличаются ровно на единицу.
Результат
Выведите «Yes», если Вова прав, и «No», если нет.
 */
public class Task_1493 {
    private static int getSum(int n) {
        int h = n / 100;
        return (n - ((h << 6) + (h << 5) + (h << 2))) / 10 + h;
    }

    public static void main(String str[]) throws Exception {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String numberLine = consoleReader.readLine();
        consoleReader.close();

        int firstNumber = Character.getNumericValue(numberLine.charAt(0))
                + Character.getNumericValue(numberLine.charAt(1))
                + Character.getNumericValue(numberLine.charAt(2));

        int secondNumber = Integer.parseInt(numberLine.substring(3));

        int last = Character.getNumericValue(numberLine.charAt(5));
        int increment = getSum(secondNumber + 1);
        int decrement = getSum(secondNumber - 1);
        if (last != 9)
            increment += last + 1;
        if (last == 0)
            decrement += 9;
        else
            decrement += last - 1;
        if (firstNumber == increment || firstNumber == decrement)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
