package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.out;

/**
 * @author Petrov Egor. Created 10.08.16.
 */
public class Task_1157 {

    public void solve(String[] input){
        if (input.length != 3)
            out.println(0);

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);
        int[] L = new int[10000];

        for (int i = 0; i < L.length; i++) {
            int count = 0;
            int sqrt = (int) Math.sqrt(i);
            for (int j = 1; j <= sqrt; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            L[i] = count;
        }

        for (int i = K; i < L.length; i++) {
            if (L[i] == M && L[i - K] == N) {
                out.println(i);
                return;
            }
        }

        out.println(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        new Task_1157().solve(input);
    }
}
