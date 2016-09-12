package ru.timus.acm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
Исходные данные
Входной поток содержит набор целых чисел Ai (0 ≤ Ai ≤ 1018), отделённых друг от друга произвольным количеством пробелов и переводов строк. Размер входного потока не превышает 256 КБ.
Результат
Для каждого числа Ai, начиная с последнего и заканчивая первым, в отдельной строке вывести его квадратный корень не менее чем с четырьмя знаками после десятичной точки.
*/

public class Task_1001 {

    public static void main(String[] str) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Deque<Long> deque = new LinkedList<>();

        while (scanner.hasNextLong())
            deque.addFirst(scanner.nextLong());

        for (Long l : deque)
            System.out.printf("%.4f\n", Math.sqrt(l));

    }
}
