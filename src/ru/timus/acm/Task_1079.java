package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Рассмотрим последовательность чисел ai, i = 0, 1, 2, …, удовлетворяющих следующим условиям:
a0 = 0
a1 = 1
a2i = ai
a2i + 1 = ai + ai + 1
для каждого i = 1, 2, 3, … .
Напишите программу, которая для заданного значения n находит максимальное среди чисел a0, a1, …, an.
Исходные данные
Входные данные состоят из нескольких тестов (не более 10). Каждый тест представляет собой строку, в которой записано целое число n (1 ≤ n ≤ 99 999).
В последней строке входных данных записано число 0.
Результат
Для каждого n во вводе выведите соответствующее максимальное значение.
 */

public class Task_1079 {

    public static void main(String[] args) throws IOException {
        List<Integer> input = getInput();
        List<Integer> sequence = getSequence(Collections.max(input));

        for (Integer i : input)
            System.out.println(Collections.max(sequence.subList(0, i + 1)));
    }

    private static List<Integer> getInput() throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> input = new ArrayList<>(10);
        String line;

        while (!(line = consoleReader.readLine()).equals("0"))
            input.add(Integer.parseInt(line));

        consoleReader.close();

        return input;
    }

    private static List<Integer> getSequence(int n) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(0);

        for (int i = 1; i <= n; i++) {
            if (i == 1)
                sequence.add(1);
            else if (i % 2 == 0)
                sequence.add(sequence.get(i/2));
            else if (i % 2 == 1)
                sequence.add(sequence.get((i - 1)/2) + sequence.get(1 + (i - 1)/2));
        }

        return sequence;
    }
}
