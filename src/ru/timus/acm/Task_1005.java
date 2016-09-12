package ru.timus.acm;

import java.util.Scanner;

/*
У вас есть несколько камней известного веса w1, …, wn. Напишите программу, которая распределит камни в две кучи так, что разность весов этих двух куч будет минимальной.
Исходные данные
Ввод содержит количество камней n (1 ≤ n ≤ 20) и веса камней w1, …, wn (1 ≤ wi ≤ 100 000) — целые, разделённые пробельными символами.
Результат
Ваша программа должна вывести одно число — минимальную разность весов двух куч.
*/

public class Task_1005 {

    public static void main(String str[]) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int w[] = new int[n];

        for (int i = 0; i < n; i++)
            w[i] = input.nextInt();

        int difference = Integer.MAX_VALUE;
        for (int c = 0; c < 1 << n; c++) {

            int heap1Weight = 0;
            int heap2Weight = 0;
            int k = c;

            for (int i = 0; i < n; i++) {
                if ((k & 1) > 0)
                    heap1Weight += w[i];
                else
                    heap2Weight += w[i];

                k >>= 1;
            }
            difference = Math.min(difference, Math.abs(heap1Weight - heap2Weight));
        }

        System.out.println(difference);
    }
}
