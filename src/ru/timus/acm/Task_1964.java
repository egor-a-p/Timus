package ru.timus.acm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by egor-a-p on 14.06.16.
 */
public class Task_1964 {
    private int n;
    private int k;
    private int[] a;

    public Task_1964(){
        try(Scanner in = new Scanner(System.in)){
            n = in.nextInt();
            k = in.nextInt();
            a = new int[k];
            IntStream.range(0, k).forEach(i -> a[i] = in.nextInt());
        }
    }

    private int solve(){
        int result = Arrays.stream(a).sum() - n * (k - 1);
        return result < 0 ? 0 : result;
    }

    public void run(){
        System.out.println(solve());
    }

    public static void main(String[] args) {
        new Task_1964().run();
    }

}
