package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_1457 {

    public static void main(String str[]) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(consoleReader.readLine());
        String[] input = consoleReader.readLine().split(" ");
        consoleReader.close();

        int p = 0;
        int q = 0;
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(input[i]);
            p += c;
            q += Math.pow(c, 2);
        }

        double d = 4 * Math.pow(1.0 * p / n, 2) - 4 * q;

        if (d <= 0)
            System.out.printf("%,.6f\n", 1.0 * p / n);
         else if (d > 0)
            System.out.printf("%,.6f\n", - 1.0 * p / n + Math.sqrt(d) / 2);
    }
}
