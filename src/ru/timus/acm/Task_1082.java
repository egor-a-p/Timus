package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Исходные данные
В первой строке содержится положительное число N ≤ 1000.
Результат
Вы должны вывести N чисел в одной строке таких, что если ввести их в программу, данную царём, то она выдаст "Василиса Прекрасная".
Числа должны быть разделены пробелами. Если возможно несколько вариантов, выведите любой.
 */

public class Task_1082 {

    public static void main(String str[]) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(consoleReader.readLine());
        for (int i = 0; i < n; i++)
            System.out.print(i + " ");
    }
}
