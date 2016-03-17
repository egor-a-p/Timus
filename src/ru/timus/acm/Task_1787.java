package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_1787 {

    public static void main(String str[]) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = consoleReader.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        int a[] = new int[n];
        input = consoleReader.readLine().split(" ");

        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(input[i]);


        int c = 0;
        for (int i = 0; i < n; i++) {
            c += a[i];
            c = (c - k) < 0 ? 0 : c - k;
        }

        System.out.println(c);
    }
}
