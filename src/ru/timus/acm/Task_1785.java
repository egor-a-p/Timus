package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_1785 {

    private static String getWordByNumber(int number) {
        if (number >= 1 && number <= 4)
            return "few";
        else if (number >= 5 && number <= 9)
            return "several";
        else if (number >= 10 && number <= 19)
            return "pack";
        else if (number >= 20 && number <= 49)
            return "lots";
        else if (number >= 50 && number <= 99)
            return "horde";
        else if (number >= 100 && number <= 249)
            return "throng";
        else if (number >= 250 && number <= 499)
            return "swarm";
        else if (number >= 500 && number <= 999)
            return "zounds";
        else if (number >= 1000)
            return "legion";
        else
            return "";
    }

    public static void main(String str[]) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String result = getWordByNumber(Integer.parseInt(consoleReader.readLine()));
        consoleReader.close();
        if (!result.equals(""))
            System.out.println(result);
    }
}
