package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
Необходимо посчитать количество «счастливых» билетов с заданной суммой цифр, среди тех, номер которых состоит из 2N разрядов.
«Счастливым» является билет, у которого сумма первых N цифр равна сумме N последних цифр.
Исходные данные
В единственной строке через пробел даны два числа: первое — N (1 ≤ N ≤ 50); второе — сумма цифр интересующих нас билетов (неотрицательное число, не превосходящее 1000).
Результат
В качестве ответа необходимо вывести найденное число «счастливых» билетов.
 */

public class Task_1036 {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = consoleReader.readLine().split(" ");
        consoleReader.close();

        int n = Integer.parseInt(input[0]);
        int sum = Integer.parseInt(input[1]);

        if ((sum & 1) == 1)
            System.out.println("0\n");
        else {
            BigInteger dp[][] = new BigInteger[51][501];
            sum >>= 1;

            dp[0][0] = BigInteger.ONE;
            for (int i = 1; i <= sum; ++i)
                dp[0][i] = BigInteger.ZERO;

            for (int i = 1; i <= n; ++i)
                for (int j = 0; j <= sum; ++j) {
                    dp[i][j] = BigInteger.ZERO;
                    for (int d = 0; d <= 9; ++d)
                        if (j >= d)
                            dp[i][j] = dp[i][j].add(dp[i - 1][j - d]);
                }


            BigInteger result = dp[n][sum].multiply(dp[n][sum]);
            System.out.println(result);
        }
    }
}