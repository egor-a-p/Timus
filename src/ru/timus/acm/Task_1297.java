package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Исходные данные
Содержит всего одну строчку (не длиннее 1000 символов), содержащую только буквы латинского алфавита (все пробелы и знаки препинания из строки Вася уже удалил).
Результат
Максимальная по длине подстрока, читающаяся одинаково в обоих направлениях. Если максимальных по длине подстрок больше одной, вывести самую левую из них.
 */
public class Task_1297 {

    public static void main(String[] args) throws IOException {
        String str = readString();
        String palindrome = "";

        for (int i = 0; i < str.length(); i++)
            for (int j = i + 1; j <= str.length(); j++){
                String subString = str.substring(i, j);
                if (isPalindrome(subString) && subString.length() > palindrome.length()) {
                    palindrome = subString;
                }
            }

        System.out.println(palindrome);
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
