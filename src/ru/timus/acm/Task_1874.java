package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Petrov Egor. Created 28.07.16.
 */
public class Task_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        double a = Double.parseDouble(input.split(" ")[0]);
        double b = Double.parseDouble(input.split(" ")[1]);

        System.out.printf("%.9f", ((a + b) * (a + b) + 2 * (Math.sqrt(2) - 1) * a * b) / 4);
    }
}
