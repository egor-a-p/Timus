package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
Рассмотрим N-значные числа в системе счисления с основанием K. Будем считать число правильным, если его K-ичная запись не содержит двух подряд идущих нулей. Например:
1010230 — правильное 7-значное число;
1000198 не является правильным числом;
0001235 — не 7-значное, а 4-значное число.
Даны числа N и K, вычислите количество правильных K-ичных чисел, состоящих из N цифр.
Ограничения: 2 ≤ K ≤ 10; N ≥ 2; N + K ≤ 1800.
Исходные данные
Числа N и K в десятичной записи, разделенные переводом строки.
Результат
Искомое количество в десятичной записи.
 */

public class Task_1012 {

    public static void main(String str[]) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(consoleReader.readLine());
        int k = Integer.parseInt(consoleReader.readLine());

        BigInteger f1 = BigInteger.valueOf(k - 1);
        BigInteger f2 = BigInteger.valueOf(k * (k - 1));
        BigInteger bk1 = BigInteger.valueOf(k - 1);

        for (int i = 2; i < n; i++) {
            BigInteger next = (f1.add(f2)).multiply(bk1);
            f1 = f2;
            f2 = next;
        }
        System.out.println(f2);
    }
}
