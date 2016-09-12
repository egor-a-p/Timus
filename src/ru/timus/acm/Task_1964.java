package ru.timus.acm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
Вова переехал из Гуанчжоу в Шэньчжэнь. Тут же выяснилось, что местные жители также не понимают его фразы на кантонском.
Вова попытался общаться с ними на мандаринском диалекте, но и тут его постигла неудача.
Тогда Вова решил узнать больше о диалектах китайского языка.
Оказалось, что в Китае говорят на k различных диалектах,
причём не менее a1 китайцев говорят на первом диалекте, не менее a2 китайцев — на втором диалекте, …, не менее ak китайцев — на k-м диалекте.
Сколько минимум китайцев говорят на всех k диалектах, если население Китая составляет n человек?
Исходные данные
В первой строке записаны целые числа n и k (2 ≤ k ≤ 20; 1 ≤ n ≤ 109). Во второй строке через пробел записаны целые числа a1, …, ak (1 ≤ ak ≤ n).
Результат
Выведите минимальное количество жителей Китая, говорящих на всех k диалектах китайского языка.
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
