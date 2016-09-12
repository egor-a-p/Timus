package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Исходные данные
В первой строке записано название предмета, который сдавал Васечкин, — непустая строка, содержащая только маленькие латинские буквы.
Длина строки не превосходит 4000 символов.
Результат
В первой строке выведите минимальное количество палиндромов, на которое можно разбить название предмета.
Во второй строке через пробел выведите палиндромы из оптимального разбиения. Если возможных ответов несколько, выведите любой.
 */
public class Task_1635 {

    public static void main(String[] args) throws IOException {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(readString());

        while (!queue.isEmpty()) {
            String str = queue.poll();
            String palindrome = getLongestPalindrome(str);
            result.add(palindrome);
            for (String tail : str.split(palindrome))
                if (!tail.equals(""))
                    queue.offer(tail);

        }

        System.out.println(result.size());
        System.out.println(result.toString().replaceAll("\\[|\\]|,", ""));
    }

    private static String getLongestPalindrome(String str) {
        String palindrome = "";

        for (int i = 0; i < str.length(); i++)
            for (int j = i + 1; j <= str.length(); j++) {
                String subString = str.substring(i, j);
                if (isPalindrome(subString) && subString.length() > palindrome.length()) {
                    palindrome = subString;
                }
            }

        return palindrome;
    }

    private static boolean isPalindrome(String str) {
        if (str == null)
            return false;
        StringBuilder strBuilder = new StringBuilder(str);
        strBuilder.reverse();
        return strBuilder.toString().equals(str);
    }

    private static String readString() throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String line = consoleReader.readLine();
        consoleReader.close();
        return line;
    }
}
