package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Исходные данные
Целое число N (1 ≤ N ≤ 100) – размер таблички.
Результат
Табличка, помеченная циферками, как она будет стоять в мастерской.
Номер один должен находиться в правом верхнем углу, далее ячейки нумеруются по диагоналям сверху вниз, последний номер (N*N) стоит в левом нижнем углу.
 */
public class Task_1319 {

    public static void main(String str[]) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(consoleReader.readLine());

        int count = 1;
        int result[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            int curJ = n - i - 1;
            for (int j = 0; j <= i; j++)
                result[j][curJ++] = count++;
        }

        for (int i = 1; i < n; i++) {
            int curI = i;
            for (int j = n - 1; j >= i; j--)
                result[curI++][n - j - 1] = count++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(result[i][j] + " ");

            System.out.println();
        }
    }
}
