package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Рассмотрим N-значные числа в системе счисления с основанием K. Будем считать число правильным, если его K-ичная запись не содержит двух подряд идущих нулей. Например:
1010230 — правильное 7-значное число;
1000198 не является правильным числом;
0001235 — не 7-значное, а 4-значное число.
Даны числа N и K, вычислите количество правильных K-ичных чисел, состоящих из N цифр.
Ограничения: 2 ≤ K ≤ 10; N ≥ 2; N + K ≤ 18.
Исходные данные
Числа N и K в десятичной записи, разделенные переводом строки.
Результат
Искомое количество в десятичной записи.
 */

public class Task_1009 {

    static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    private static int checkNumber(int n, int radix) {
        if (n <= 0) return 1;
        if (n == 1) return radix - 1;
        else return (checkNumber(n - 1, radix) + checkNumber(n - 2, radix)) * (radix - 1);
    }

    public static void main(String str[]) throws IOException {
        int n = Integer.parseInt(consoleReader.readLine());
        int radix = Integer.parseInt(consoleReader.readLine());

        System.out.println(checkNumber(n, radix));
    }
}
