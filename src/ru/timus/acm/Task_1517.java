package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_1517 {

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(consoleReader.readLine());
        String line1 = consoleReader.readLine();
        String line2 = consoleReader.readLine();
        System.out.println(longestCS(n, line1, line2));
    }


    private static String longestCS(int n, String a, String b) {
        if (a.equals(b)) return a;

        int[][] matrix = new int[n][n];

        int maxLength = 0;
        int maxI = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (a.charAt(i) == b.charAt(j)) {
                    if (i != 0 && j != 0)
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    else
                        matrix[i][j] = 1;
                    if (matrix[i][j] > maxLength) {
                        maxLength = matrix[i][j];
                        maxI = i;
                    }
                }

        return a.substring(maxI - maxLength + 1, maxI + 1);
    }
}
