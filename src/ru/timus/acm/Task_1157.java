package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.out;

/*
У одного маленького мальчика было много-много одинаковых квадратных плиток.
Больше всего на свете он любил выкладывать все свои плитки в виде прямоугольника — он уже наизусть выучил все виды прямоугольников, которые можно получить, используя все плитки!
На день рождения ему подарили ещё несколько таких же плиток. Разумеется, мальчик сразу занялся своим любимым делом — выкладыванием прямоугольников.
Вскоре он уже выучил все виды прямоугольников, которые можно получить с новым количеством плиток.
Надо отметить, что хотя мальчик легко может пересчитать число прямоугольников, он не знает, сколько всего у него плиток — вероятно, их слишком много для такого маленького мальчика.
Но, конечно, для вас не составит труда определить, сколько плиток сейчас у мальчика, зная, сколько прямоугольников он мог сложить раньше,
сколько может сложить сейчас и сколько плиток ему подарили.
Даны числа M, N и K. Найдите наименьшее число плиток L, такое что из L плиток можно сложить N разных прямоугольников, а из L − K плиток можно сложить M разных прямоугольников.
Исходные данные
Целые числа M, N и K (1 ≤ M, N, K ≤ 10000).
Результат
Если L не превосходит 10000, то выведите это число (если возможных L несколько, выведите наименьшее). Если задача не имеет решения или наименьшее возможное L > 10000, выведите число 0.
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
