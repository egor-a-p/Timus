package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
Исходные данные
В первой строке дано единственное целое число n — количество секций стены (3 ≤ n ≤ 1000).
Во второй строке через пробел записаны n положительных целых чисел ai — сила магического поля на каждой из секций (1 ≤ ai ≤ 106).
Результат
Выдайте через пробел два числа — максимальную суммарную силу поля возле трёх подряд идущих секций стены и номер средней из них. Гарантируется, что ответ всегда однозначен.

 */
public class Task_1910 {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(consoleReader.readLine());
        int[] a = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(consoleReader.readLine(), " ");
        consoleReader.close();

        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(tokenizer.nextToken());

        int maxPower = 0;
        int position = 0;
        for (int i = 0; i < n - 2; i++) {
            int sum = a[i] + a[i + 1] + a[i + 2];
            if (sum > maxPower) {
                maxPower = sum;
                position = i + 2;
            }
        }

        System.out.println(maxPower + " " + position);
    }
}
