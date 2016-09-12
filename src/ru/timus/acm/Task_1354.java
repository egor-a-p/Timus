package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Под словом будем понимать некоторую непустую последовательность символов a1a2…an.
Палиндромом будем называть такое слово a1a2…an, которое читается одинаково как слева направо, так и справа налево (т.е. что a1a2…an = anan−1…a1).
Если S1 = a1a2…an и S2 = b1b2…bm, то тогда S1S2 = a1a2…anb1b2…bm. Вам дано некоторое слово S1.
Ваша задача — найти такое непустое слово S2 минимальной длины, что S1S2 — палиндром.
Исходные данные
В первой строке записано S1 (оно может состоять только из символов латиницы). Гарантируется, что длина S1 не превышает 10000 символов.
Результат
Выведите S1S2.
 */
public class Task_1354 {

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String line = consoleReader.readLine();
        consoleReader.close();

        if (line.length() == 1)
            System.out.println(line + line);
        else
            for (int i = 1; i < line.length(); i++){
                String subString = line.substring(i);
                if (isPalindrome(subString)){
                StringBuilder sb = new StringBuilder(line.substring(0, i));
                System.out.println(line + sb.reverse());
                break;
                }
            }
    }

    private static boolean isPalindrome(String str) {
        if (str == null)
            return false;
        StringBuilder strBuilder = new StringBuilder(str);
        strBuilder.reverse();
        return strBuilder.toString().equals(str);
    }
}
