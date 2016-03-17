package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_1639 {

    public static void main(String str[]) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = consoleReader.readLine().split(" ");
        consoleReader.close();

        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int calc = m * n - 1;

        if ((calc & 1) > 0)
            System.out.println("[:=[first]");
        else
            System.out.println("[second]=:]");
    }
}
